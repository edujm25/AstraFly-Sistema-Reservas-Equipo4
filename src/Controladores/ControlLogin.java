package Controladores;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelos.UserDAO;
import Modelos.User;
import vista.LoginVista;

/**
 *
 * @author shing
 */
public class ControlLogin implements ActionListener {
    UserDAO dao = new UserDAO();
    User u = new User();
    LoginVista loginV = new LoginVista();
    
    public ControlLogin(LoginVista l) {
        this.loginV = l;
        this.loginV.getBtnIngresar().addActionListener(this);
        
        limpiarCampos(l);
    }
    
    //Metodo que se encarga de limpiar los campos
    private void limpiarCampos(LoginVista l) {
        l.getTxtUsuario().setText("");
        l.getTxtContrasena().setText("");
        l.getTxtUsuario().requestFocus();
    }
    
    //Metodo para validar los campos
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
