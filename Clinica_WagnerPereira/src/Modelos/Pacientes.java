/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 * Essa classe representa um funcionario do nosso aplicativo
 *
 * @author 202202189278
 */
public class Pacientes {

    private int Id;
    private String NomeCompleto;
    private String Email;
    private String Cpf;
    private String Tipo_Sanguineo;
    private String Sexo;
    private String Telefone;
    private String Contato_Emergencial;
    private boolean TemPlano = false;
    private int PlanoId;
    private String Observacoes;

    public Pacientes() {
    }

    public Pacientes(int id,
            String nomeCompleto,
            String email,
            String cpf,
            String tipo_Sanguineo,
            String sexo,
            String telefone,
            String contato_Emergencial,
            boolean temPlano,
            int planoId,
            String observacoes
    ) {
        this.Id = id;
        this.NomeCompleto = nomeCompleto;
        this.Email = email;
        this.Cpf = cpf;
        this.Tipo_Sanguineo = tipo_Sanguineo;
        this.Sexo = sexo;
        this.Telefone = telefone;
        this.Contato_Emergencial = contato_Emergencial;
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

    public String getNomeCompleto() {
        return this.NomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.NomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCpf() {
        return this.Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getTipo_Sanguineo() {
        return this.Tipo_Sanguineo;
    }

    public void setTipo_Sanguineo(String tipo_Sanguineo) {
        this.Tipo_Sanguineo = tipo_Sanguineo;
    }

    public String getSexo() {
        return this.Sexo;
    }

    public void setSexo(String sexo) {
        this.Sexo = sexo;
    }

    public String getTelefone() {
        return this.Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public String getContato_Emergencial() {
        return this.Contato_Emergencial;
    }

    public void setContato_Emergencial(String contato_Emergencial) {
        this.Contato_Emergencial = contato_Emergencial;
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
