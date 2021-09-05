/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PORTATIL
 */
public class var {
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
    
    public Icon SetIcono(String url,JButton boton){
        ImageIcon icon=new ImageIcon(getClass().getResource(url));
        
        int ancho=boton.getWidth();
        
        int alto=boton.getHeight();
        
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        return icono;
        
        
    }
    
    public Icon SetIconoPrecionado(String url,JButton boton,int ancho,int largo){
        ImageIcon icon=new ImageIcon(getClass().getResource(url));
        
        int anchob=boton.getWidth()-ancho;
        
        int altob=boton.getHeight()-largo;
        
        ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(anchob, altob, Image.SCALE_DEFAULT));
        
        return icono;
        
        
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
