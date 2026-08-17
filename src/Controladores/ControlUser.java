package Controladores;

import Modelos.User;
import Modelos.UserDAO;
import vista.PanelesAdmin.PanelUsuariosAdmin;
import vista.PanelesAdmin.ventanas.DialogUsuarios;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controlador del panel de Usuarios.
 *
 * @author Edwis Jimenez
 */
public class ControlUser implements ActionListener {

    UserDAO dao = new UserDAO();
    PanelUsuariosAdmin vista;
    DefaultTableModel modelo;

    public ControlUser(PanelUsuariosAdmin v) {
        this.vista = v;

        configurarTabla();
        listar();

        this.vista.getBtnEditar().setEnabled(false);
        this.vista.getBtnEliminar().setEnabled(false);

        this.vista.getTblUsuarios().getSelectionModel().addListSelectionListener(e -> {
            boolean haySeleccion = vista.getTblUsuarios().getSelectedRow() != -1;
            vista.getBtnEditar().setEnabled(haySeleccion);
            vista.getBtnEliminar().setEnabled(haySeleccion);
        });

        this.vista.getBtnNuevo().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
    }

    private void configurarTabla() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Pasaporte", "Correo ", "Numero_Telefono"};
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
        // El panel no tiene un combo para elegir la columna,
        // asi que se busca en varias columnas a la vez.
        mostrarEnTabla(dao.buscarGeneral(texto));
    }

    private void mostrarEnTabla(List<User> usuarios) {
        limpiarTabla();
        for (User u : usuarios) {
            modelo.addRow(new Object[]{
                    u.getId(),
                    u.getNombreUsuario(),
                    u.getNombreApellido(),
                    u.getDocumentoCedulaPasaporte(),
                    u.getCorreo(),
                    u.getNumeroTelefonico()
            });
        }
    }

    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    public void agregar() {
        DialogUsuarios dialogo = new DialogUsuarios(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(vista), true);
        dialogo.setUsuario(null);
        dialogo.setVisible(true);

        if (dialogo.isGuardado()) {
            User nuevo = dialogo.getUsuario();
            int r = dao.agregar(nuevo);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario agregado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de agregar el usuario.\nVerifica que el usuario, correo, documento y telefono no esten ya registrados.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editar() {
        int fila = vista.getTblUsuarios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila para la edicion.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) vista.getTblUsuarios().getValueAt(fila, 0);
        User usuario = dao.buscarPorId(id);

        if (usuario == null) {
            JOptionPane.showMessageDialog(vista, "Ese usuario ya no existe.", "Error!", JOptionPane.ERROR_MESSAGE);
            listar();
            return;
        }

        DialogUsuarios dialogo = new DialogUsuarios(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(vista), true);
        dialogo.setUsuario(usuario);
        dialogo.setVisible(true);

        if (dialogo.isGuardado()) {
            User editado = dialogo.getUsuario();
            int r = dao.actualizar(editado);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario actualizado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de actualizar el usuario.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void eliminar() {
        int fila = vista.getTblUsuarios().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila a borrar.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = (int) vista.getTblUsuarios().getValueAt(fila, 0);
        String nombreUsuario = (String) vista.getTblUsuarios().getValueAt(fila, 1);

        if (JOptionPane.showConfirmDialog(vista, "Esta seguro de eliminar el usuario " + nombreUsuario + "?", "Borrar", JOptionPane.YES_NO_OPTION) == 0) {
            int r = dao.eliminar(id);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario eliminado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                listar();
            } else {
                JOptionPane.showMessageDialog(vista, "Error: tratando de eliminar el usuario.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

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