package Controladores;

import Modelos.Vuelo;
import Modelos.VueloDAO;
import vista.PanelesAdmin.PanelVuelosAdmin;
import vista.PanelesAdmin.ventanas.DialogVuelo;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controlador del panel de Vuelos.
 *
 * @author Edwis Jimenez
 */
public class ControlVuelos implements ActionListener {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    VueloDAO dao = new VueloDAO();
    PanelVuelosAdmin vista;
    DefaultTableModel modelo;

    /**
     * Constructor del controlador de Vuelos. Se encarga de inicializar los
     * componentes del panel. Recibe como parametro el panel "PanelVuelosAdmin".
     *
     * @param v
     */
    public ControlVuelos(PanelVuelosAdmin v) {
        this.vista = v;

        configurarTabla();
        listar();

        this.vista.getBtnEditar().setEnabled(false);
        this.vista.getBtnEliminar().setEnabled(false);

        this.vista.getTblVuelos().getSelectionModel().addListSelectionListener(e -> {
            boolean haySeleccion = vista.getTblVuelos().getSelectedRow() != -1;
            vista.getBtnEditar().setEnabled(haySeleccion);
            vista.getBtnEliminar().setEnabled(haySeleccion);
        });

        this.vista.getBtnNuevo().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
    }

    /**
     * Prepara el modelo de la tabla (columnas, no editable).
     */
    private void configurarTabla() {
        String[] columnas = {"ID", "Numero", "Aerolinea", "Origen", "Destino", "Fecha", "Hora", "Precio"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vista.getTblVuelos().setModel(modelo);
    }

    /**
     * Este metodo se encarga de cargar todos los vuelos dentro de la tabla.
     */
    public final void listar() {
        mostrarEnTabla(dao.listar());
    }

    /**
     * Este metodo se encarga de cargar los vuelos que coincidan con la
     * busqueda dentro de la tabla.
     */
    public void listarRegistro() {
        String texto = vista.getTxtBuscar().getText().trim();
        if (texto.isEmpty()) {
            listar();
            return;
        }

        String columna;
        switch ((String) vista.getCbBuscarPor().getSelectedItem()) {
            case "Numero":
                columna = "numero";
                break;
            case "Aerolinea":
                columna = "aerolinea";
                break;
            case "Origen":
                columna = "origen";
                break;
            case "Destino":
                columna = "destino";
                break;
            default:
                columna = "numero";
        }

        mostrarEnTabla(dao.buscarPorColumna(columna, texto));
    }

    private void mostrarEnTabla(List<Vuelo> vuelos) {
        limpiarTabla();
        for (Vuelo v : vuelos) {
            modelo.addRow(new Object[]{
                    v.getId(),
                    v.getNumeroVuelo(),
                    v.getAerolinea(),
                    v.getOrigen(),
                    v.getDestino(),
                    v.getFecha().format(FORMATO_FECHA),
                    v.getHora().format(FORMATO_HORA),
                    v.getPrecio()
            });
        }
    }

    /**
     * Este metodo se encarga de limpiar la tabla antes de recargarla.
     */
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    /**
     * Abre el dialogo vacio para registrar un nuevo vuelo, y si el usuario
     * guarda, lo inserta en la base de datos.
     */
    public void agregar() {
        DialogVuelo dialogo = new DialogVuelo(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(vista), true);
        dialogo.setVuelo(null);
        dialogo.setVisible(true);

        if (dialogo.isGuardado()) {
            Vuelo nuevo = dialogo.getVuelo();
            int r = dao.agregar(nuevo);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Vuelo agregado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de agregar el vuelo.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Abre el dialogo con los datos del vuelo seleccionado en la tabla, y si
     * el usuario guarda, actualiza la base de datos.
     */
    public void editar() {
        int fila = vista.getTblVuelos().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila para la edicion.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) vista.getTblVuelos().getValueAt(fila, 0);
        Vuelo vuelo = dao.buscarPorId(id);

        if (vuelo == null) {
            JOptionPane.showMessageDialog(vista, "Ese vuelo ya no existe.", "Error!", JOptionPane.ERROR_MESSAGE);
            listar();
            return;
        }

        DialogVuelo dialogo = new DialogVuelo(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(vista), true);
        dialogo.setVuelo(vuelo);
        dialogo.setVisible(true);

        if (dialogo.isGuardado()) {
            Vuelo editado = dialogo.getVuelo();
            int r = dao.actualizar(editado);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Vuelo actualizado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de actualizar el vuelo.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Este metodo procede a eliminar el vuelo seleccionado dentro de la tabla.
     */
    public void eliminar() {
        int fila = vista.getTblVuelos().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila a borrar.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) vista.getTblVuelos().getValueAt(fila, 0);
        String numeroVuelo = (String) vista.getTblVuelos().getValueAt(fila, 1);

        if (JOptionPane.showConfirmDialog(vista, "Esta seguro de eliminar el vuelo " + numeroVuelo + "?", "Borrar", JOptionPane.YES_NO_OPTION) == 0) {
            int r = dao.eliminar(id);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Vuelo eliminado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de eliminar el vuelo.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Este metodo verifica si se ha producido algun evento dentro del panel.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnNuevo()) {
            agregar();
        }
        if (e.getSource() == vista.getBtnEditar()) {
            editar();
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
        if (e.getSource() == vista.getBtnBuscar()) {
            listarRegistro();
        }
    }
}