/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import ifpe.edu.smbg.model.Persistivel;

/**
 *
 * @author pronatec
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "Cod_Parada"))
public class PontosDeParada extends Persistivel implements Serializable{
    
    @Column(name = "rua", length = 30, nullable = false)
    private String rua;
    
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;

    @ManyToMany(mappedBy = "pontosDeParada")
    private List<Rota> rotas;

    public PontosDeParada(String rua, String bairro, List<Rota> rotas) {
        this.rua = rua;
        this.bairro = bairro;
        this.rotas = rotas;
    }
    
    public PontosDeParada() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    
}
