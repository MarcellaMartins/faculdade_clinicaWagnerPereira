/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.text.ParseException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

/**
 * Essa classe representa um funcionario do nosso aplicativo
 *
 * @author 202202189278
 */
public class Funcionarios {

    private int Id;
    private String NomeCompleto;
    private String Email;
    private String Cpf;
    private String Telefone;
    private String Coren;
    private String Formacao;
    private int EspecialidadeId;
    private String Matricula;
    private String Senha;

    // ideia o pro futuro
    public void gerarMatricula() {
        int max = 100000;
        int min = 1000;
        int range = max - min + 1;
        // generate random numbers within 1 to 10
        int rand = (int)(Math.random() * range) + min;
        this.Matricula = Integer.toString(rand);
    }

    public Funcionarios() {
    }

    public Funcionarios(int id,
            String nomeCompleto,
            String email,
            String cpf,
            String telefone,
            String coren,
            String formacao,
            int especialidadeId,
            String matricula,
            String senha
    ) {
        this.Id = id;
        this.NomeCompleto = nomeCompleto;
        this.Email = email;
        this.Cpf = cpf;
        this.Telefone = telefone;
        this.Coren = coren;
        this.Telefone = formacao;
        this.EspecialidadeId = especialidadeId;
        this.Matricula = matricula;
        this.Senha = senha;
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

    public String getTelefone() {
        return this.Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public String getCoren() {
        return this.Coren;
    }

    public void setCoren(String coren) {
        this.Coren = coren;
    }

    public String getFormacao() {
        return this.Formacao;
    }

    public void setFormacao(String formacao) {
        this.Formacao = formacao;
    }

    public int getEspecialidadeId() {
        return this.EspecialidadeId;
    }

    public void setEspecialidadeId(int especialidadeId) {
        this.EspecialidadeId = especialidadeId;
    }

    public String getMatricula() {
        return this.Matricula;
    }

    public void setMatricula(String matricula) {
        this.Matricula = matricula;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }
}
