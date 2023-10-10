/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.Funcionario;
import Telas.Agendamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 202202189278
 */
public class AgendamentoDao implements DaoGenerica<Agendamento> {

    private ConexaoBanco conexao;

    public AgendamentoDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Agendamento obj) {
        String sql = "INSERT INTO funcionarios (NomeCompleto, Email, Cpf, Telefone, Coren, EspecialidadeId, Formacao, Matricula, Senha) VALUES(?,?,?,?,?,?,?,?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                /*query.setString(1, obj.NomeCompleto);
                query.setString(2, obj.Email);
                query.setString(3, obj.Cpf);
                query.setString(4, obj.Telefone);
                query.setString(5, obj.Coren);
                query.setInt(6, obj.EspecialidadeId);
                query.setString(7, obj.Formacao);
                query.setString(8, obj.Matricula);
                query.setString(9, obj.Senha);*/

                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void altera(Agendamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Agendamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Agendamento> consultar() {
        String sql = "Select * from funcionarios order by nomeCompleto";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = query.executeQuery();
                /*while (resultado.next()) {
                    func.NomeCompleto = resultado.getString("NomeCompleto");
                    func.Cpf = resultado.getString("Cpf");
                    func.Email = resultado.getString("Email");
                    func.Formacao = resultado.getString("Formacao");
                    func.Telefone = resultado.getString("Telefone");
                    func.Coren = resultado.getString("Coren");
                    func.EspecialidadeId = resultado.getInt("EspecialidadeId");
                    func.Matricula = resultado.getString("Matricula");
                    func.Senha = resultado.getString("Senha");
                    list.add(func)
                }*/
                query.close();
                this.conexao.getConnection().close();
                return new ArrayList<Agendamento>();
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<Agendamento>();
        }
        return new ArrayList<Agendamento>();
    }

    public boolean consultarPorNome(String nome) {
        String sql = "Select * from funcionarios where matricula = ? and senha = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);

                query.setString(1, nome);
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionario> list = new ArrayList<>();
                Funcionario func = new Funcionario();
                while (resultado.next()) {
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
