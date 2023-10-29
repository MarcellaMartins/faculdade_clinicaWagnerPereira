package Modelos;

import java.time.LocalDateTime;

/**
 *
 * @author 202202189278
 */
public class Agendamentos {

    private int Id;
    private int PacienteId;
    private String DataConsulta;
    private String HoraConsulta;
    private int TipoConsultaId;
    private int DoutorId;
    private double ValorConsulta;
    private int Desconto;
    private String Observacoes;

    public Agendamentos() {
    }

    public Agendamentos(
            int id,
            int pacienteId,
            String dataConsulta,
            String horaConsulta,
            int tipoConsultaId,
            int doctorId,
            double valorConsulta,
            int desconto,
            String observacoes
    ) {
        this.Id = id;
        this.PacienteId = pacienteId;
        this.DataConsulta = dataConsulta;
        this.HoraConsulta = horaConsulta;
        this.TipoConsultaId = tipoConsultaId;
        this.DoutorId = doctorId;
        this.ValorConsulta = valorConsulta;
        this.Desconto = desconto;
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

    public String getDataConsulta() {
        return this.DataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.DataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return this.HoraConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.HoraConsulta = horaConsulta;
    }

    public int getTipoConsultaId() {
        return this.TipoConsultaId;
    }

    public void setTipoConsultaId(int tipoConsultaId) {
        this.TipoConsultaId = tipoConsultaId;
    }

    public int getDoctorId() {
        return this.DoutorId;
    }

    public void setDoctorId(int doctorId) {
        this.DoutorId = doctorId;
    }

    public double getValorConsulta() {
        return this.ValorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.ValorConsulta = valorConsulta;
    }

    public int getDesconto() {
        return this.Desconto;
    }

    public void setDesconto(int desconto) {
        this.Desconto = desconto;
    }

    public String getObservacoes() {
        return this.Observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.Observacoes = observacoes;
    }
}
