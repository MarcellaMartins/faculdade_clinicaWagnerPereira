/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.Pacientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 202202189278
 */
public class PacientesDao implements DaoGenerica<Pacientes> {

    private ConexaoBanco conexao;

    public PacientesDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Pacientes obj) {
        String sql = "INSERT INTO Pacientes (NomeCompleto, Email, Cpf, Tipo_Sanguinio, Sexo, Telefone, Contato_Emergencial, TemPlano, PlanoId, Observacoes) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, obj.getNomeCompleto());
                query.setString(2, obj.getEmail());
                query.setString(3, obj.getCpf());
                query.setString(4, obj.getTipo_Sanguineo());
                query.setString(5, obj.getSexo());
                query.setString(6, obj.getTelefone());
                query.setString(7, obj.getContato_Emergencial());
                query.setBoolean(8, obj.getTemPlano());
                query.setInt(9, obj.getPlanoId());
                query.setString(10, obj.getObservacoes());
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void alterar(Pacientes obj) {
        String sql = "Update Pacientes "
                + "set NomeCompleto = ?, "
                + "Email = ?, "
                + "Cpf = ?, "
                + "Tipo_Sanguinio = ?, "
                + "Sexo = ?, "
                + "Telefone = ?, "
                + "Contato_Emergencial = ?, "
                + "TemPlano = ?, "
                + "PlanoId = ?, "
                + "Observacoes = ? "
                + "where Id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, obj.getNomeCompleto());
                query.setString(2, obj.getEmail());
                query.setString(3, obj.getCpf());
                query.setString(4, obj.getTipo_Sanguineo());
                query.setString(5, obj.getSexo());
                query.setString(6, obj.getTelefone());
                query.setString(7, obj.getContato_Emergencial());
                query.setBoolean(8, obj.getTemPlano());
                query.setInt(9, obj.getPlanoId());
                query.setString(10, obj.getObservacoes());

                query.setInt(11, obj.getId());
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to update data");
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "Delete from Pacientes where Id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to delete user");
        }
    }

    @Override
    public ArrayList<Pacientes> consultar() {
        String sql = "Select * from Pacientes order by id";
        try {
            if (this.conexao.conectar()) {
                ArrayList<Pacientes> list;
                try (PreparedStatement query = this.conexao.getConnection().prepareStatement(sql)) {
                    ResultSet resultado = query.executeQuery();
                    list = new ArrayList<>();
                    while (resultado.next()) {
                        Pacientes func = new Pacientes();
                        func.setId(resultado.getInt("Id"));
                        func.setNomeCompleto(resultado.getString("NomeCompleto"));
                        func.setEmail(resultado.getString("Email"));
                        func.setCpf(resultado.getString("Cpf"));
                        func.setTipo_Sanguineo(resultado.getString("Tipo_Sanguinio"));
                        func.setSexo(resultado.getString("Sexo"));
                        func.setTelefone(resultado.getString("Telefone"));
                        func.setContato_Emergencial(resultado.getString("Contato_Emergencial"));
                        func.setTemPlano(resultado.getBoolean("TemPlano"));
                        func.setPlanoId(resultado.getInt("PlanoId"));
                        func.setObservacoes(resultado.getString("Observacoes"));
                        list.add(func);
                    }
                }
                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public boolean consultarExistencia(int id) {
        String sql = "Select * from Pacientes where id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);

                ResultSet resultado = query.executeQuery();
                ArrayList<Pacientes> list = new ArrayList<>();
                while (resultado.next()) {
                    Pacientes func = new Pacientes();
                    func.setId(resultado.getInt("Id"));
                    func.setNomeCompleto(resultado.getString("NomeCompleto"));
                    func.setEmail(resultado.getString("Email"));
                    func.setCpf(resultado.getString("Cpf"));
                    func.setTipo_Sanguineo(resultado.getString("Tipo_Sanguinio"));
                    func.setSexo(resultado.getString("Sexo"));
                    func.setTelefone(resultado.getString("Telefone"));
                    func.setContato_Emergencial(resultado.getString("Contato_Emergencial"));
                    func.setTemPlano(resultado.getBoolean("TemPlano"));
                    func.setPlanoId(resultado.getInt("PlanoId"));
                    func.setObservacoes(resultado.getString("Observacoes"));
                    list.add(func);
                }
                if (!list.isEmpty()) {
                    return true;
                }
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
        }
        return false;
    }

    public Pacientes consultarId(int id) {
        String sql = "Select * from Pacientes where id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);

                ResultSet resultado = query.executeQuery();
                ArrayList<Pacientes> list = new ArrayList<>();
                while (resultado.next()) {
                    Pacientes func = new Pacientes();
                    func.setId(resultado.getInt("Id"));
                    func.setNomeCompleto(resultado.getString("NomeCompleto"));
                    func.setEmail(resultado.getString("Email"));
                    func.setCpf(resultado.getString("Cpf"));
                    func.setTipo_Sanguineo(resultado.getString("Tipo_Sanguinio"));
                    func.setSexo(resultado.getString("Sexo"));
                    func.setTelefone(resultado.getString("Telefone"));
                    func.setContato_Emergencial(resultado.getString("Contato_Emergencial"));
                    func.setTemPlano(resultado.getBoolean("TemPlano"));
                    func.setPlanoId(resultado.getInt("PlanoId"));
                    func.setObservacoes(resultado.getString("Observacoes"));
                    list.add(func);
                }
                if (!list.isEmpty()) {
                    return list.get(0);
                }
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
        }
        return null;
    }

    public ArrayList<Pacientes> consultarNome(String nome) {
        String sql = "Select * from Pacientes where lower(NomeCompleto) like ? order by NomeCompleto";
        try {
            if (this.conexao.conectar()) {
                ArrayList<Pacientes> list;
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, nome);

                ResultSet resultado = query.executeQuery();
                list = new ArrayList<>();
                while (resultado.next()) {
                    Pacientes func = new Pacientes();
                    query.setString(1, "%" + nome.toLowerCase() + "%");

                    func.setId(resultado.getInt("Id"));
                    func.setNomeCompleto(resultado.getString("NomeCompleto"));
                    func.setEmail(resultado.getString("Email"));
                    func.setCpf(resultado.getString("Cpf"));
                    func.setTipo_Sanguineo(resultado.getString("Tipo_Sanguinio"));
                    func.setSexo(resultado.getString("Sexo"));
                    func.setTelefone(resultado.getString("Telefone"));
                    func.setContato_Emergencial(resultado.getString("Contato_Emergencial"));
                    func.setTemPlano(resultado.getBoolean("TemPlano"));
                    func.setPlanoId(resultado.getInt("PlanoId"));
                    func.setObservacoes(resultado.getString("Observacoes"));
                    list.add(func);
                }

                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}
