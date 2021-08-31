/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barf;

import Clases.var;
import inter_faces.pricipal;
import javax.swing.JFrame;

/**
 *
 * @author PORTATIL
 */
public class Barf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        var v;
        v=new var();
        pricipal vn;
        vn=new pricipal(v);
        vn.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        vn.setTitle("Principal");
        vn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vn.setLocationRelativeTo(null);
        vn.setVisible(true);
        
    }
    
}
