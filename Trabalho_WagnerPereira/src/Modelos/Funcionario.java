/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 * Essa classe representa um funcionario do nosso aplicativo
 * @author 202202189278
 */
public class Funcionario {
    
    public int Id;
    
    public String NomeCompleto;
    
    public String Email;
    
    public String Cpf;
    
    public String Telefone;
    
    public String Coren;
    
    public String Formacao;
    
    public int EspecialidadeId;
    
    public String Matricula;
    
    public String Senha;
    
    // ideia o pro futuro
    public String gerarMatricula(){
        Random random = new Random();
        String ret = random.longs(0, 10000).toString();
        return ret;
    }
}
