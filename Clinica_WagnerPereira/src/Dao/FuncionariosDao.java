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
    public void alterar(Funcionarios obj) {
        String sql = "Update Funcionarios "
                + "set NomeCompleto = ?,"
                + "Email = ?, "
                + "Cpf = ?,"
                + "Telefone = ?,"
                + "Coren = ?,"
                + "EspecialidadeId = ?,"
                + "Formacao = ?,"
                + "Matricula = ?,"
                + "Senha = ?"
                + "where Id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                Funcionarios func = new Funcionarios();

                query.setString(1, obj.getNomeCompleto());
                query.setString(2, obj.getEmail());
                query.setString(3, obj.getCpf());
                query.setString(4, obj.getTelefone());
                query.setString(5, obj.getCoren());
                query.setInt(6, obj.getEspecialidadeId());
                query.setString(7, obj.getFormacao());
                query.setString(8, obj.getMatricula());
                query.setString(9, obj.getSenha());
                query.setInt(10, obj.getId());

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
        String sql = "Delete from funcionarios where id = ?";
        try {
            if (this.conexao.conectar()) {
                if (consultarExistencia(id)) {
                    PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                    query.setInt(1, id);
                    query.execute();
                    query.close();
                    this.conexao.getConnection().close();
                }
            } else {
                System.err.println("Error to delete not existance data");
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
        }
    }

    @Override
    public ArrayList<Funcionarios> consultar() {
        String sql = "Select * from funcionarios order by Id";
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

    public ArrayList<Funcionarios> consultarNomes(String nome) {
        String sql = "Select * from funcionarios where Lower(NomeCompleto) like ? order by NomeCompleto";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, "%" + nome.toLowerCase() + "%");
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

    public boolean consultarExistencia(int id) {
        String sql = "Select * from funcionarios where id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);

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

    public ArrayList<Funcionarios> consultarPorEspecialidade(int especialidadeId) {
        String sql = "Select * from funcionarios where EspecialidadeId = ? order by Id ";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, especialidadeId);
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

    public Funcionarios consultarId(int id) {
        String sql = "Select * from funcionarios where id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);

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

    public boolean consultarMatricula(String matricula) {
        String sql = "Select * from funcionarios where matricula = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, matricula);

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
                if (list.isEmpty()) {
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

    public int consultarLogin(String email, String senha) {
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
                
                query.close();
                this.conexao.getConnection().close();
                
                if (!list.isEmpty()) {
                    return list.get(0).getId();
                }
                return 0;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return 0;
        }
        return 0;
    }
}
