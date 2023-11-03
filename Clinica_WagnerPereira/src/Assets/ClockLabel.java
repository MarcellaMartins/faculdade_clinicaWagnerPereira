package Assets;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author 202202189278
 */
public class ClockLabel extends JLabel {
    //Locale local = new Locale("pt", "Br");
    SimpleDateFormat formatarData = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
    SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm:ss");
    private Date d = new Date();

    public ClockLabel() {
    }

    public ClockLabel(Date d) {
        this.d = d;
    }

    public String getData() {
        return formatarData.format(d);
    }

    public String getHora() {
        return formatarHora.format(d);
    }

    public String getDiaSemana() {
        String diaSemana = "";
        switch (d.getDay()) {
            case 0:
                diaSemana = "Domingo";
                break;
            case 1:
                diaSemana = "Segunda-feira";
                break;
            case 2:
                diaSemana = "Terça-feira";
                break;
            case 3:
                diaSemana = "Quarta-feira";
                break;
            case 4:
                diaSemana = "Quinta-feira";
                break;
            case 5:
                diaSemana = "Sexta-feira";
                break;
            case 6:
                diaSemana = "Sábado";
                break;
        }
        return diaSemana;
    }
}
