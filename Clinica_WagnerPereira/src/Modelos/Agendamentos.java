package Modelos;

import java.util.Date;

/**
 *
 * @author 202202189278
 */
public class Agendamentos {

    private int Id;
    private int PacienteId;
    private Date DataConsulta;
    private int TipoConsultaId;
    private int DoctorId;
    private Boolean TemPlano;
    private int PlanoId;
    private String Observacoes;

    public Agendamentos() {
    }

    public Agendamentos(
            int id,
            int pacienteId,
            Date dataConsulta,
            int tipoConsultaId,
            int doctorId,
            boolean temPlano,
            int planoId,
            String observacoes
    ) {
        this.Id = id;
        this.PacienteId = pacienteId;
        this.DataConsulta = dataConsulta;
        this.TipoConsultaId = tipoConsultaId;
        this.DoctorId = doctorId;
        this.TemPlano = temPlano;
        this.PlanoId = planoId;
        this.Observacoes = observacoes;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getPacienteId() {
        return this.PacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.PacienteId = pacienteId;
    }

    public Date getDataConsulta() {
        return this.DataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.DataConsulta = dataConsulta;
    }

    public int getTipoConsultaId() {
        return this.TipoConsultaId;
    }

    public void setTipoConsultaId(int tipoConsultaId) {
        this.TipoConsultaId = tipoConsultaId;
    }

    public int getDoctorId() {
        return this.DoctorId;
    }

    public void setDoctorId(int doctorId) {
        this.DoctorId = doctorId;
    }

    public boolean getTemPlano() {
        return this.TemPlano;
    }

    public void setTemPlano(boolean temPlano) {
        this.TemPlano = temPlano;
    }

    public int getPlanoId() {
        return this.PlanoId;
    }

    public void setPlanoId(int planoId) {
        this.PlanoId = planoId;
    }

    public String getObservacoes() {
        return this.Observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.Observacoes = observacoes;
    }
}
