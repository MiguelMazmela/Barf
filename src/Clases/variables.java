/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import inter_faces.Departamentos;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PORTATIL
 */
public class variables {

    //conecta conexion;
    private Connection con;
    private Boolean editando;
    private String codigoEdicion;
    private DefaultTableModel modelo;

    public void borratabla(DefaultTableModel modelo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public Icon SetIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));

        int ancho = boton.getWidth();

        int alto = boton.getHeight();

        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

        return icono;

    }

    public Icon SetIconoPrecionado(String url, JButton boton, int ancho, int largo) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));

        int anchob = boton.getWidth() - ancho;

        int altob = boton.getHeight() - largo;

        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(anchob, altob, Image.SCALE_DEFAULT));

        return icono;

    }

    public DefaultListModel carga_lista(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DefaultListModel lista = new DefaultListModel();
        String sql = "";

        switch (i) {
            case 1:
                sql = "Select * from departamentos";
                break;
            case 2:
                sql = "Select * from provincias";
                break;
            case 3:
                sql = "Select * from distrito";
                break;
            case 4:
                sql = "Select * from CIUDAD";
                break;
        }

//        sql = "Select * from departamentos";
        try {
//            PreparedStatement ps = v.getCon().prepareStatement(sql);
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                lista.addElement(rs.getObject(1));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public String getCodigoEdicion() {
        return codigoEdicion;
    }

    public void setCodigoEdicion(String codigoEdicion) {
        this.codigoEdicion = codigoEdicion;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

}
