package Controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelos.User;
import Modelos.UserDAO;
import vista.Login;
import vista.Menu;

/**
 *
 * @author shing
 */
public class ControlLogin implements ActionListener {

    UserDAO dao = new UserDAO();
    User u = new User();
    Login loginV;

    public ControlLogin(Login l) {
        this.loginV = l;
        this.loginV.getBtnIngresar().addActionListener(this);

        limpiarCampos(l);
    }

    // Metodo que se encarga de limpiar los campos
    private void limpiarCampos(Login l) {
        l.getTxtUsuario().setText("");
        l.getTxtContrasena().setText("");
        l.getTxtUsuario().requestFocus();
    }

    // Metodo para validar que los campos no esten vacios
    private boolean validarCampos(Login l) {
        if (l.getTxtUsuario().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(loginV, "El campo de usuario no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            l.getTxtUsuario().requestFocus();
            return false;
        }
        if (l.getTxtContrasena().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(loginV, "El campo de clave no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            l.getTxtContrasena().requestFocus();
            return false;
        }
        return true;
    }

    public boolean accionarLogin(String usuario, String clave, Login login) {
        if (validarCampos(login)) {
            try {
                if (dao.realizarLogin(usuario, clave)) {
                    JOptionPane.showMessageDialog(loginV, "Ingresado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    login.setVisible(false);

                    Menu m = new Menu();
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(login, "Error al tratar de ingresar.\nEl usuario o la clave estan incorrectos!", "Error!", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos(login);
                    return false;
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(loginV, "Error al tratar de ingresar: " + e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginV.getBtnIngresar()) {
            String usuario = loginV.getTxtUsuario().getText();
            String clave = loginV.getTxtContrasena().getText();
            accionarLogin(usuario, clave, loginV);
        }
    }
}