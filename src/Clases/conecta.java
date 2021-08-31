/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author PORTATIL
 */
public final class conecta {

    public conecta() {
        
        this.conectar();
        
    }
    
    public Connection conectar() {
        Connection con = null;
        
        try {
            Class.forName("org.sqlite.JDBC"); 
            
            String url = "/home/miguel/Mio/Java/barf/src/db/mi_base.db";
//            String url = "./src/db/mi_base.db";
//        Connection connect;
//            Class.forName("org.sqlite.JDBC ");
            con = DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.print("conecto");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null,"No se conecto");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
        
    }
    
    public void cierra(){
        try {
            conectar().close();
        } catch (SQLException ex) {
            Logger.getLogger(conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
