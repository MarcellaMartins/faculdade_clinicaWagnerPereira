/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.Funcionarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 202202189278
 */
public class FuncionariosDao implements DaoGenerica<Funcionarios> {

    private ConexaoBanco conexao;

    public FuncionariosDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Funcionarios obj) {
        String sql = "INSERT INTO funcionarios (NomeCompleto, Email, Cpf, Telefone, Coren, EspecialidadeId, Formacao, Matricula, Senha) VALUES(?,?,?,?,?,?,?,?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, obj.getNomeCompleto());
                query.setString(2, obj.getEmail());
                query.setString(3, obj.getCpf());
                query.setString(4, obj.getTelefone());
                query.setString(5, obj.getCoren());
                query.setInt(6, obj.getEspecialidadeId());
                query.setString(7, obj.getFormacao());
                query.setString(8, obj.getMatricula());
                query.setString(9, obj.getSenha());

                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void altera(Funcionarios obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Funcionarios obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionarios> consultar() {
        String sql = "Select * from funcionarios order by nomeCompleto";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionarios> list = new ArrayList<>();
                while (resultado.next()) {
                    Funcionarios func = new Funcionarios();
                    func.setId(resultado.getInt("Id"));
                    func.setNomeCompleto(resultado.getString("NomeCompleto"));
                    func.setCpf(resultado.getString("Cpf"));
                    func.setEmail(resultado.getString("Email"));
                    func.setFormacao(resultado.getString("Formacao"));
                    func.setTelefone(resultado.getString("Telefone"));
                    func.setCoren(resultado.getString("Coren"));
                    func.setEspecialidadeId(resultado.getInt("EspecialidadeId"));
                    func.setMatricula(resultado.getString("Matricula"));
                    func.setSenha(resultado.getString("Senha"));
                    list.add(func);
                }
                query.close();
                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<Funcionarios>();
        }
        return new ArrayList<Funcionarios>();
    }

    public boolean consultarLogin(String email, String senha) {
        String sql = "Select * from funcionarios where matricula = ? and senha = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);

                query.setString(1, email);
                query.setString(2, senha);
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionarios> list = new ArrayList<>();
                while (resultado.next()) {
                    Funcionarios func = new Funcionarios();
                    func.setId(resultado.getInt("Id"));
                    func.setNomeCompleto(resultado.getString("NomeCompleto"));
                    func.setCpf(resultado.getString("Cpf"));
                    func.setEmail(resultado.getString("Email"));
                    func.setFormacao(resultado.getString("Formacao"));
                    func.setTelefone(resultado.getString("Telefone"));
                    func.setCoren(resultado.getString("Coren"));
                    func.setEspecialidadeId(resultado.getInt("EspecialidadeId"));
                    func.setMatricula(resultado.getString("Matricula"));
                    func.setSenha(resultado.getString("Senha"));
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
