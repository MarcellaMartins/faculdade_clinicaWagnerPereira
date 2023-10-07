package Modelos;

import java.util.Date;

/**
 *
 * @author 202202189278
 */
public class Agendamento {

    public int Id;

    public String Nome;

    public int Sexo;

    public Date DataConsulta;

    public int TipoConsultaId;

    public int DoctorId;

    public Boolean temPlano = false;
    
    public int PlanoId;
}
