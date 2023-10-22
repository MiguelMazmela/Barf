/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
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

    private String sSistemaOperativo;
    private String CaminoCompletoBD;
    private boolean conectado = false;
    private String usuario;
    private Boolean UsuarioValido;
    private boolean edicion = false;

    public conecta() {

        this.conectar();

    }

    public Connection conectar() {
        Connection con = null;
        this.sSistemaOperativo = System.getProperty("os.name");
        String sFichero = "mi_base.db";
        String sDirectorio = "db";

        String sPath = getCurrentDir() + File.separator + sDirectorio + File.separator + sFichero;
        CaminoCompletoBD = sPath;

        try {
            Class.forName("org.sqlite.JDBC");
//            String url = "/home/miguel/Mio/Java/barf/src/db/mi_base.db";
            con = DriverManager.getConnection("jdbc:sqlite:" + sPath);
            System.out.print("conecto");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "No se conecto");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conecta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }

    public String getsSistemaOperativo() {
        return sSistemaOperativo;
    }

    public void setsSistemaOperativo(String sSistemaOperativo) {
        this.sSistemaOperativo = sSistemaOperativo;
    }

    public String getCaminoCompletoBD() {
        return CaminoCompletoBD;
    }

    public void setCaminoCompletoBD(String CaminoCompletoBD) {
        this.CaminoCompletoBD = CaminoCompletoBD;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getUsuarioValido() {
        return UsuarioValido;
    }

    public void setUsuarioValido(Boolean UsuarioValido) {
        this.UsuarioValido = UsuarioValido;
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }

    public void cierra() {
        try {
            conectar().close();
        } catch (SQLException ex) {
            Logger.getLogger(conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getCurrentDir() {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        String dir;
//        System.out.print(helper);
        dir = helper.substring(0, helper.length() - 2); //this line may need a try-catch
        return dir;
    }

}
