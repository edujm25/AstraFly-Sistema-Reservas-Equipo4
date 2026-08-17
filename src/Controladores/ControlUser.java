package Controladores;
import Modelos.User;
import Modelos.UserDAO;
import vista.PanelesAdmin.PanelUsuariosAdmin;
import vista.PanelesAdmin.ventanas.DialogReservas;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import vista.PanelesAdmin.PanelUsuariosAdmin;
import Modelos.UserDAO;

/**
 *
 * @author shing
 */
public class ControlUser implements ActionListener  {
    


    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    UserDAO dao = new UserDAO();
    PanelUsuariosAdmin vista;
    DefaultTableModel modelo;

    public ControlUser(PanelUsuariosAdmin v) {
        this.vista = v;

        configurarTabla();
        listar();

        this.vista.getBtnEditar().setEnabled(false);

        this.vista.getTblUsuarios().getSelectionModel().addListSelectionListener(e -> {
            boolean haySeleccion = vista.getTblUsuarios().getSelectedRow() != -1;
            vista.getBtnEditar().setEnabled(haySeleccion);
        });

        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
    }

    private void configurarTabla() {
        String[] columnas = {"ID", "Usuario_id", "Vuelo_id", "Codigo_Reserva", "Nombre_Pasajero", "Fecha_Reserva", "Estado", "Precio_Pagado"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vista.getTblUsuarios().setModel(modelo);
    }

    public final void listar() {
        mostrarEnTabla(dao.listar());
    }

    public void listarRegistro() {
        String texto = vista.getTxtBuscar().getText().trim();
        if (texto.isEmpty()) {
            listar();
            return;
        }

       // String columna;
       // switch ((String) vista.getCbBuscarPor().getSelectedItem()) {
       //     case "Codigo":   columna = "codigo";   break;
       //     case "Pasajero": columna = "pasajero"; break;
       //     case "Estado":   columna = "estado";   break;
        //    default:         columna = "codigo";
       // }

        mostrarEnTabla(dao.buscarPorColumna(columna, texto));
    }

    private void mostrarEnTabla(List<User> reservas) {
        limpiarTabla();
        for (User r : reservas) {
            modelo.addRow(new Object[]{
                    r.getId(),
                    r.getIdUsuario(),
                    r.getIdVuelo(),
                    r.getCodigoReserva(),
                    r.getNombrePasajero(),
                    r.getFechaReserva() != null ? r.getFechaReserva().format(FORMATO_FECHA) : "",
                    r.getEstado(),
                    r.getPrecioPagado()
            });
        }
    }

    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    public void editar() {
        int fila = vista.getTblUsuarios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila para la edicion.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) vista.getTblUsuarios().getValueAt(fila, 0);
        User user = dao.buscarPorId(id);

        if (user == null) {
            JOptionPane.showMessageDialog(vista, "Esa reserva ya no existe.", "Error!", JOptionPane.ERROR_MESSAGE);
            listar();
            return;
        }

        DialogReservas dialogo = new DialogReservas(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(vista), true);
        dialogo.setReserva(user);
        dialogo.setVisible(true);

        if (dialogo.isGuardado()) {
            User editada = dialogo.getReserva();
            int r = dao.actualizar(editada);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Reserva actualizada con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de actualizar la reserva.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnEditar()) {
            editar();
        }
        if (e.getSource() == vista.getBtnBuscar()) {
            listarRegistro();
        }
    }
}
