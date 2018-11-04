package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Table;

import ifpe.edu.smbg.model.Persistivel;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Rotas")
@AttributeOverride(name = "id", column = @Column(name = "Cod_Rota"))
public class Rota extends Persistivel implements Serializable, Comparable<Rota> {

    @Column(name = "Origem", length = 30, nullable = false)
    private String origem;

    @Column(name = "Destino", length = 30, nullable = false)
    private String destino;

    @Column(name = "horarioSaida", length = 5, nullable = false)
    private String horarioSaida;

    @Column(name = "horarioPrevisto", length = 5, nullable = false)
    private String horarioPrevistoDeChegada;

    @ManyToOne
    @JoinColumn(name = "Cod_onibus", referencedColumnName = "Cod_Onibus")
    private Onibus OnibusQueFazemEstaRota;

    @JoinTable (name = "Rotas_tem_PontosDeParada", 
            joinColumns = {@JoinColumn(name = "Cod_rota",
                referencedColumnName = "Cod_Rota")},
            inverseJoinColumns = {@JoinColumn(name = "Cod_parada", 
                    referencedColumnName = "Cod_Parada")})
    @ManyToMany
    private List<PontosDeParada> pontosDeParada;

    public Rota() {

    }

    public Rota(String origem, String destino, String horarioSaida, String horarioPrevistoDeChegada, Onibus OnibusQueFazemEstaRota, List<PontosDeParada> pontosDeParada) {
        this.origem = origem;
        this.destino = destino;
        this.horarioSaida = horarioSaida;
        this.horarioPrevistoDeChegada = horarioPrevistoDeChegada;
        this.OnibusQueFazemEstaRota = OnibusQueFazemEstaRota;
        this.pontosDeParada = pontosDeParada;
    }
    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getHorarioPrevistoDeChegada() {
        return horarioPrevistoDeChegada;
    }

    public void setHorarioPrevistoDeChegada(String horarioPrevistoDeChegada) {
        this.horarioPrevistoDeChegada = horarioPrevistoDeChegada;
    }

    public List<PontosDeParada> getPontosDeParada() {
        return pontosDeParada;
    }

    public void setPontosDeParada(List<PontosDeParada> pontosDeParada) {
        this.pontosDeParada = pontosDeParada;
    }
    public Onibus getOnibusQueFazemEstaRota() {
        return OnibusQueFazemEstaRota;
    }

    public void setOnibusQueFazemEstaRota(Onibus OnibusQueFazemEstaRota) {
        this.OnibusQueFazemEstaRota = OnibusQueFazemEstaRota;
    }
    
    
    public int compareTo(Rota rota) {
        if(this.origem.compareTo(rota.origem) > 0) {
            return 1;
        } else if (this.origem.compareTo(rota.origem) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Rota)) {
            return false;
        }

        Rota rota = (Rota) obj;

        return this.origem.equals(rota.origem) && this.destino.equals(rota.destino) && this.horarioSaida.equals(rota.horarioSaida);

    }

}
