/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.model;

import java.util.ArrayList;
import java.util.List;

import ifpe.edu.smbg.model.entity.Funcionario;

/**
 *
 * @author TON
 */
public class IteratorFuncionario implements Iterator<Funcionario>{

    private List<Funcionario> lista = new ArrayList<Funcionario>();
    private int contador;

    public IteratorFuncionario() {
    }

    public IteratorFuncionario(List<Funcionario> lista) {
        this.lista = lista;
        this.contador = 0;
    }
    
    public boolean hasNext() {
        return this.contador < lista.size();
    }

    public Funcionario next() {
        return lista.get(this.contador++);
    }
    
    
    
}
