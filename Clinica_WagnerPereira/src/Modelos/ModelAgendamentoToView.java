/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author 202202189278
 */
public class ModelAgendamentoToView {

    public int Id;
    public String Paciente;
    public String DataConsulta;
    public String HoraConsulta;
    public int TipoConsultaId;
    public String Doutor;
    public String Observacoes;

    public ModelAgendamentoToView() {
    }

    public ModelAgendamentoToView(
            int id,
            String paciente,
            String dataConsulta,
            String horaConsulta,
            int tipoConsultaId,
            String doctor,
            String observacoes
    ) {
        this.Id = id;
        this.Paciente = paciente;
        this.DataConsulta = dataConsulta;
        this.HoraConsulta = horaConsulta;
        this.TipoConsultaId = tipoConsultaId;
        this.Doutor = doctor;
        this.Observacoes = observacoes;
    }
}
