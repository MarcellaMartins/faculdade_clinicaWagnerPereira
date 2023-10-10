/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 202202189278
 */
public class FuncionarioDao implements DaoGenerica<Funcionario> {

    private ConexaoBanco conexao;

    public FuncionarioDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Funcionario obj) {
        String sql = "INSERT INTO funcionarios (NomeCompleto, Email, Cpf, Telefone, Coren, EspecialidadeId, Formacao, Matricula, Senha) VALUES(?,?,?,?,?,?,?,?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, obj.NomeCompleto);
                query.setString(2, obj.Email);
                query.setString(3, obj.Cpf);
                query.setString(4, obj.Telefone);
                query.setString(5, obj.Coren);
                query.setInt(6, obj.EspecialidadeId);
                query.setString(7, obj.Formacao);
                query.setString(8, obj.Matricula);
                query.setString(9, obj.Senha);

                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void altera(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> consultar() {
        String sql = "Select * from funcionarios order by nomeCompleto";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionario> list = new ArrayList<>();
                while (resultado.next()) {
                    Funcionario func = new Funcionario();
                    func.Id = resultado.getInt("Id");
                    func.NomeCompleto = resultado.getString("NomeCompleto");
                    func.Cpf = resultado.getString("Cpf");
                    func.Email = resultado.getString("Email");
                    func.Formacao = resultado.getString("Formacao");
                    func.Telefone = resultado.getString("Telefone");
                    func.Coren = resultado.getString("Coren");
                    func.EspecialidadeId = resultado.getInt("EspecialidadeId");
                    func.Matricula = resultado.getString("Matricula");
                    func.Senha = resultado.getString("Senha");
                    list.add(func);
                }
                query.close();
                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<Funcionario>();
        }
        return new ArrayList<Funcionario>();
    }

    public boolean consultarLogin(String email, String senha) {
        String sql = "Select * from funcionarios where matricula = ? and senha = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);

                query.setString(1, email);
                query.setString(2, senha);
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionario> list = new ArrayList<>();
                while (resultado.next()) {
                    Funcionario func = new Funcionario();
                    func.NomeCompleto = resultado.getString("NomeCompleto");
                    func.Cpf = resultado.getString("Cpf");
                    func.Email = resultado.getString("Email");
                    func.Formacao = resultado.getString("Formacao");
                    func.Telefone = resultado.getString("Telefone");
                    func.Coren = resultado.getString("Coren");
                    func.EspecialidadeId = resultado.getInt("EspecialidadeId");
                    func.Matricula = resultado.getString("Matricula");
                    func.Senha = resultado.getString("Senha");
                    list.add(func);
                }
                boolean ret = !list.isEmpty();
                query.close();
                this.conexao.getConnection().close();
                return ret;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return false;
        }
        return false;
    }
}
