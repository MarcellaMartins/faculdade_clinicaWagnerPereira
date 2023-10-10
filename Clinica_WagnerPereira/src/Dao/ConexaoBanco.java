/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 202202189278
 */
public class ConexaoBanco {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;

    public ConexaoBanco() {
        this.servidor = "localhost";
        this.banco = "clinicaWagnerPereira";
        this.usuario = "root";
        this.senha = "";
    }

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
            return false;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acesasr o banco.");
            return false;
        }
    }

    public Connection getConnection() {
        return this.conexao;
    }

    /*public void closeConnection() {
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
