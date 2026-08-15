/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import vista.Login;
import Controladores.ControlLogin;
/**
 *
 * @author shing
 */
public class Main {
     public static void main(String args[]) {
        Login lv = new Login();
        ControlLogin cl = new ControlLogin(lv);
        lv.setVisible(true);
        lv.setLocationRelativeTo(null);
    }
}
