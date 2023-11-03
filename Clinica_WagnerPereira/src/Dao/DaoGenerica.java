/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author 202202189278
 * @param <ObjetoGenerico>
 */
public interface DaoGenerica<ObjetoGenerico> {

    public void inserir(ObjetoGenerico obj);

    public void alterar(ObjetoGenerico obj);

    public void excluir(int id);

    public ArrayList<ObjetoGenerico> consultar();
}
