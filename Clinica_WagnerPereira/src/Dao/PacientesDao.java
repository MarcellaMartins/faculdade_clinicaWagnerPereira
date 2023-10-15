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
        String sql = "INSERT INTO funcionarios (NomeCompleto, Email, Cpf, Telefone, Coren, EspecialidadeId, Formacao, Matricula, Senha) VALUES(?,?,?,?,?,?,?,?, ?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, obj.getNomeCompleto());
                query.setString(2, obj.getEmail());
                query.setString(3, obj.getCpf());
                query.setString(4, obj.getTipo_Sanguinio());
                query.setString(5, obj.getSexo());
                query.setString(6, obj.getTelefone());
                query.setString(7, obj.getContato_Emergencial());
                query.setBoolean(8, obj.getTemPlano());
                query.setInt(9, obj.getPlanoId());
                query.setString(5, obj.getObservacoes());
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void altera(Pacientes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Pacientes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pacientes> consultar() {
        String sql = "Select * from funcionarios order by nomeCompleto";
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
                        func.setTipo_Sanguinio(resultado.getString("Tipo_Sanguinio"));
                        func.setSexo(resultado.getString("Sexo"));
                        func.setTelefone(resultado.getString("Telefone"));
                        func.setContato_Emergencial(resultado.getString("Contato_Emergencial"));
                        func.setTemPlano(resultado.getBoolean("TemPlano"));
                        func.setPlanoId(resultado.getInt("PlanoId("));
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
}
