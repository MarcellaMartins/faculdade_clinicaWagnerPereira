package Assets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 202202189278
 */
public class Mock {

    public String[] GetEspecialidades() {
        String[] especialidades = {
            "Clínico Geral", "Pediatria", "Cirurgião Geral", "Ginecologista", "Odontologia", "Cardiologista", "Urologista", "Neurologista"
        };
        return especialidades;
    }

    public String[] GetPlanos() {
        String[] planos = {
            "Amil", "Golden Cross", "Saúde Caixa", "Sul América"
        };
        return planos;
    }

    public String[] GetDescontos() {
        String[] descontos = {
            "0", "10", "20", "30", "50", "60"
        };
        return descontos;
    }

    public String[] GetPrecos() {
        String[] precos = {
            "50", "80", "100", "200", "250", "300", "350", "500", "600", "650"
        };
        return precos;
    }

    public String[] GetTipo_Sanguineo() {
        String[] sangue = {
            "A+",
            "A-",
            "B+",
            "B-",
            "AB+",
            "AB-",
            "O+",
            "O-"
        };
        return sangue;
    }

    public String[] GetGenero() {
        String[] sexo = {
            "F", "M", "NR"
        };
        return sexo;
    }
}
