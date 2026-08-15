/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    UserDAO dao = new UserDAO ();
    User u = new User ();
    Login lv = new Login ();
    
    public ControlLogin(Login l) {
        this.lv = l;
        this.lv.getBtnIniciar().addActionListener(this);
        
        //Limpiar campos
        limpiarCampos(lv);
    }
    
    private void limpiarCampos(Login u) {
        u.getTxtUsuario().setText("");
        u.getTxtContrasena().setText("");
        u.getTxtUsuario().requestFocus();
    }
    
    
     private boolean validarCampos(Login u) {
            if (u.getTxtUsuario().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(lv, "El campo de usuario no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            u.getTxtUsuario().requestFocus();
            return false;
            }
            if (u.getTxtContrasena().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(lv, "El campo de clave no debe estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);
            u.getTxtContrasena().requestFocus();
            return false;
            }
        return true;
    }
    
    
     
     
     
     public boolean AccionarLogin(String usuario, String clave, Login login) {
        if (validarCampos(login)) {
            System.out.println("campos del formulario validados que no esten vacios!");
            try {
                System.out.println("verificando si los datos existen!");
                if (dao.realizarLogin(usuario, clave)) {
                    JOptionPane.showMessageDialog(lv, "Ingresado con exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    login.setVisible(false);
                    System.out.println("ingresando a formulario de contactos contactos!");
                    Menu m = new Menu();
                   
                    // aqui intanciar a l clase controlador menu 
                    
                    
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                    return true;
                } else{
                    JOptionPane.showMessageDialog(login,"Error al tratar de ingresar.\n El usuario o la clave estan incorrectos!", "Error!",JOptionPane.ERROR_MESSAGE);
                    limpiarCampos(login);
                    return false;
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(lv, "Error al tratar de ingresar: " + e, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
    
    
   @Override
        public void actionPerformed(ActionEvent e) {
            //Validando si se presiono el botón
            if (e.getSource() == lv.getBtnIniciar()) {
            String usuario = lv.getTxtUsuario().getText();
            String clave   = lv.getTxtContrasena().getText();
            AccionarLogin(usuario, clave, lv);
            
            
            // este if es para boton de cerrar programa
             //if (e.getSource() == lv.AQUI PONER EL NOMBRE DE LA VARIABLE DEL BOTON) {
            //System.exit(0);
        //}
        }
}
    
}
