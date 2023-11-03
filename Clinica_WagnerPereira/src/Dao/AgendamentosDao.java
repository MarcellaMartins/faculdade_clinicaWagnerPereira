/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelos.Agendamentos;
import Modelos.Funcionarios;
import Modelos.ModelAgendamentoToView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 202202189278
 */
public class AgendamentosDao implements DaoGenerica<Agendamentos> {

    private ConexaoBanco conexao;

    public AgendamentosDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Agendamentos obj) {
        String sql = "INSERT INTO Agendamentos (PacienteId, DataConsulta, HoraConsulta, TipoConsultaId, DoutorId, ValorConsulta, Desconto, Observacoes) VALUES(?,?,?,?,?,?,?,?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, obj.getPacienteId());
                query.setString(2, obj.getDataConsulta());
                query.setString(3, obj.getHoraConsulta());
                query.setInt(4, obj.getTipoConsultaId());
                query.setInt(5, obj.getDoctorId());
                query.setDouble(6, obj.getValorConsulta());
                query.setInt(7, obj.getDesconto());
                query.setString(8, obj.getObservacoes());
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to insert data");
        }
    }

    @Override
    public void alterar(Agendamentos obj) {
        String sql = "Update Agendamentos set PacienteId = ?, DataConsulta = ?, HoraConsulta = ?, TipoConsultaId = ?, DoutorId =?, ValorConsulta =?, Desconto = ?, Observacoes=? where id =  ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, obj.getPacienteId());
                query.setString(2, obj.getDataConsulta());
                query.setString(3, obj.getHoraConsulta());
                query.setInt(4, obj.getTipoConsultaId());
                query.setInt(5, obj.getDoctorId());
                query.setDouble(6, obj.getValorConsulta());
                query.setInt(7, obj.getDesconto());
                query.setString(8, obj.getObservacoes());
                query.setInt(9, obj.getId());
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
        String sql = "Delete from Agendamentos where id = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, id);
                query.execute();
                query.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println("Error to delete data");
        }
    }

    @Override
    public ArrayList<Agendamentos> consultar() {
        String sql = "Select * from Agendamentos order by dataConsulta, horaConsulta";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = query.executeQuery();
                ArrayList<Agendamentos> list = new ArrayList<Agendamentos>();
                while (resultado.next()) {
                    Agendamentos agenda = new Agendamentos();
                    agenda.setId(resultado.getInt("Id"));
                    agenda.setPacienteId(resultado.getInt("PacienteId"));
                    agenda.setTipoConsultaId(resultado.getInt("TipoConsultaId"));
                    agenda.setDataConsulta(resultado.getString("DataConsulta"));
                    agenda.setHoraConsulta(resultado.getString("HoraConsulta"));
                    agenda.setDoctorId(resultado.getInt("DoutorId"));
                    agenda.setValorConsulta(resultado.getDouble("ValorConsulta"));
                    agenda.setDesconto(resultado.getInt("Desconto"));
                    agenda.setObservacoes(resultado.getString("Observacao"));
                    list.add(agenda);
                }
                query.close();
                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<Agendamentos>();
        }
        return new ArrayList<Agendamentos>();
    }

    public ArrayList<ModelAgendamentoToView> consultarModelToView() {
        String dataHj = LocalDate.now().toString();
        String sql = "Select "
                + " a.Id as Id, "
                + " p.NomeCompleto as paciente, "
                + " a.DataConsulta, "
                + " a.HoraConsulta, "
                + " a.TipoConsultaId, "
                + " f.NomeCompleto as doutor, "
                + " a.Observacoes "
                + " from Agendamentos a "
                + " inner join Pacientes p on p.Id = a.PacienteId "
                + " inner join funcionarios f on f.Id = a.DoutorId "
                + " where a.DataConsulta >= '" + dataHj + "'"
                + " order by a.dataConsulta, a.horaConsulta";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultado = query.executeQuery();
                ArrayList<ModelAgendamentoToView> list = new ArrayList<ModelAgendamentoToView>();
                while (resultado.next()) {

                    ModelAgendamentoToView agenda = new ModelAgendamentoToView();
                    agenda.Id = resultado.getInt("Id");
                    agenda.Paciente = resultado.getString("Paciente");
                    agenda.DataConsulta = resultado.getString("DataConsulta");
                    agenda.HoraConsulta = resultado.getString("HoraConsulta");
                    agenda.TipoConsultaId = resultado.getInt("TipoConsultaId");
                    agenda.Doutor = resultado.getString("Doutor");
                    agenda.Observacoes = resultado.getString("Observacoes");

                    list.add(agenda);
                }
                query.close();
                this.conexao.getConnection().close();
                return list;
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ArrayList<ModelAgendamentoToView>();
        }
        return new ArrayList<ModelAgendamentoToView>();
    }

    public ModelAgendamentoToView consultarModelToViewById(int consultaId) {
        String dataHj = LocalDate.now().toString();
        String sql = "Select "
                + " a.Id as Id, "
                + " p.NomeCompleto as paciente, "
                + " a.DataConsulta, "
                + " a.HoraConsulta, "
                + " a.TipoConsultaId, "
                + " f.NomeCompleto as doutor, "
                + " a.Observacoes "
                + " from Agendamentos a "
                + " inner join Pacientes p on p.Id = a.PacienteId "
                + " inner join funcionarios f on f.Id = a.DoutorId "
                + " where a.id = ? "
                + " order by a.dataConsulta, a.horaConsulta";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setInt(1, consultaId);
                ResultSet resultado = query.executeQuery();
                ArrayList<ModelAgendamentoToView> list = new ArrayList<ModelAgendamentoToView>();
                while (resultado.next()) {
                    ModelAgendamentoToView agenda = new ModelAgendamentoToView();
                    agenda.Id = resultado.getInt("Id");
                    agenda.Paciente = resultado.getString("Paciente");
                    agenda.DataConsulta = resultado.getString("DataConsulta");
                    agenda.HoraConsulta = resultado.getString("HoraConsulta");
                    agenda.TipoConsultaId = resultado.getInt("TipoConsultaId");
                    agenda.Doutor = resultado.getString("Doutor");
                    agenda.Observacoes = resultado.getString("Observacoes");
                    list.add(agenda);
                }
                query.close();
                this.conexao.getConnection().close();
                return list.get(0);
            }
        } catch (SQLException e) {
            System.err.println("Error to select data");
            return new ModelAgendamentoToView();
        }
        return new ModelAgendamentoToView();
    }

    public boolean consultarPorNome(String nome) {
        String sql = "Select * from Agendamento a"
                + " inner join funcionarios f on f.id = a.pacienteId "
                + " where NomeCompleto like ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement query = this.conexao.getConnection().prepareStatement(sql);
                query.setString(1, "%" + nome + "%");
                ResultSet resultado = query.executeQuery();
                ArrayList<Funcionarios> list = new ArrayList<>();
                Funcionarios func = new Funcionarios();
                while (resultado.next()) {
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
