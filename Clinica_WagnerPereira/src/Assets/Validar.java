/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 202202189278
 */
public class Validar {

    public String validarMascaraCpf(String cpf) {
        String mask = "###.###.###-##";
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(mask);
            mf.setValueContainsLiteralCharacters(false);
            cpf = mf.valueToString(cpf);
        } catch (ParseException ex) {
            System.out.println("Assets.Validar.validarMascaraCpf()");
        }
        return cpf;
    }

    public boolean validarCpf(String cpf) {
        boolean valido = false;
        String expression = "/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()) {
            valido = true;
        }
        return valido;
    }

    public boolean validarEmail(String email) {
        boolean valido = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            valido = true;
        }
        return valido;
    }

    public String validarMascaraTelefone(String telefone) {
        String mask;
        switch (telefone.length()) {
            case 8:
                mask = "####-####";
                break;
            case 9:
                mask = "#####-####";
                break;
            case 10:
                mask = "(##) ####-####";
                break;
            case 11:
                mask = "(##) #####-####";
                break;
            default:
                return telefone;
        }
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(mask);
            mf.setValueContainsLiteralCharacters(false);
            telefone = mf.valueToString(telefone);
        } catch (ParseException ex) {

        }
        return telefone;
    }

    public boolean validarTelefones(String telefone) {
        boolean valido = false;
        String expression = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telefone);
        if (matcher.matches()) {
            valido = true;
        }
        return valido;
    }
}
