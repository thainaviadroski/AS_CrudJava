/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import DAO.ConnectionPg;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karol
 */
public class testeMain {
  
    public static void main(String[] args) {
        ConnectionPg con = new ConnectionPg();
        
        try {
            con.connect();
        } catch (Exception ex) {
            Logger.getLogger(testeMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
