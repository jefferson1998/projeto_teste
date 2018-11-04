package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import ifpe.edu.smbg.model.Persistivel;

@Entity
@Table(name = "Seguro")
@AttributeOverride(name = "id", column = @Column(name = "Cod_Seguro"))
public class SeguroOnibus extends Persistivel implements Serializable, Comparable<SeguroOnibus> {

    @ManyToOne
    @JoinColumn(name = "Cod_onibus", referencedColumnName = "Cod_Onibus")
    private Onibus onibus;
    
    @Column(name = "codigoSusepCorretor", nullable = false)
    private String codigoSusepDoCorretor;
    
    @Column(name = "codigoCpdCorretor", nullable = false)
    private String codigoCpdDoCorretor;
    
    @Column(name = "sucursalCorretor", nullable = false)
    private String sucursalCorretor;
    
    @Column(name = "inspetoriaCorretor", nullable = false)
    private String inspetoriaDoCorretor;
    
    @Column(name = "proposta", nullable = false)
    private String proposta;
    
    @Column(name = "dataEmissao", nullable = false)
    private String dataEmissao;
    
    @Column(name = "apolice", nullable = false)
    private String apolice;
    
    @Column(name = "sucursal", nullable = false)
    private String sucursal;
    
    @Column(name = "processoSusep", nullable = false)
    private String processoSusep;
    
    @Column(name = "codigoSusep", nullable = false)
    private String codigoSusep;
    
    @Column(name = "cnpjSeguradora", nullable = false)
    private String cnpjSeguradora;
    
    @Column(name = "nomeSeguradora", nullable = false)
    private String nomeSeguradora;
    
//    @ElementCollection
//    @CollectionTable(name="Telefone_Segurado", joinColumns = @JoinColumn(name="Cod_Seguro"))
//    private List<String> telefoneDoSegurado;
    
    @Embedded
    private Endereco endereco;
    
    @Column(name = "nomeCorretor", nullable = false)
    private String nomeCorretor;
    
    @Column(name = "cpfOuCnpjSegurado", nullable = false)
    private String cpfOuCnpjDoSegurado;
    
    @Column(name = "nomeSegurado", nullable = false)
    private String nomeDoSegurado;
    
    @Column(name = "inicioVigencia", nullable = false)
    private String dataInicioDaVigencia;
    
    @Column(name = "fimVigencia", nullable = false)
    private String dataFinalDaVigencia;
    
    @Column(name = "numeroEndosso", nullable = false)
    private String numeroEndosso;
    
    @Column(name = "ramo", nullable = false)
    private String ramo;

    public SeguroOnibus() {
        endereco = new Endereco();
        onibus = new Onibus();
    }
    
    public String getCodigoSusepDoCorretor() {
        return codigoSusepDoCorretor;
    }

    public void setCodigoSusepDoCorretor(String codigoSusepDoCorretor) {
        this.codigoSusepDoCorretor = codigoSusepDoCorretor;
    }

    public String getCodigoCpdDoCorretor() {
        return codigoCpdDoCorretor;
    }

    public void setCodigoCpdDoCorretor(String codigoCpdDoCorretor) {
        this.codigoCpdDoCorretor = codigoCpdDoCorretor;
    }

    public String getSucursalCorretor() {
        return sucursalCorretor;
    }
 
    public void setSucursalCorretor(String sucursalCorretor) {
        this.sucursalCorretor = sucursalCorretor;
    }

    public String getInspetoriaDoCorretor() {
        return inspetoriaDoCorretor;
    }

    public void setInspetoriaDoCorretor(String inspetoriaDoCorretor) {
        this.inspetoriaDoCorretor = inspetoriaDoCorretor;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getApolice() {
        return apolice;
    }

    public void setApolice(String apolice) {
        this.apolice = apolice;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getProcessoSusep() {
        return processoSusep;
    }

    public void setProcessoSusep(String processoSusep) {
        this.processoSusep = processoSusep;
    }

    public String getCodigoSusep() {
        return codigoSusep;
    }

    public void setCodigoSusep(String codigoSusep) {
        this.codigoSusep = codigoSusep;
    }

    public String getCnpj() {
        return cnpjSeguradora;
    }

    public void setCnpj(String cnpj) {
        this.cnpjSeguradora = cnpj;
    }

    public String getNomeSeguradora() {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) {
        this.nomeSeguradora = nomeSeguradora;
    }

//    public List<String> getTelefoneDoSegurado() {
//        return telefoneDoSegurado;
//    }
//
//    public void setTelefoneDoSegurado(List<String> telefoneDoSegurado) {
//        this.telefoneDoSegurado = telefoneDoSegurado;
//    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeCorretor() {
        return nomeCorretor;
    }

    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }

    public String getCpfOuCnpjDoSegurado() {
        return cpfOuCnpjDoSegurado;
    }

    public void setCpfOuCnpjDoSegurado(String cpfOuCnpjDoSegurado) {
        this.cpfOuCnpjDoSegurado = cpfOuCnpjDoSegurado;
    }

    public String getNomeDoSegurado() {
        return nomeDoSegurado;
    }

    public void setNomeDoSegurado(String nomeDoSegurado) {
        this.nomeDoSegurado = nomeDoSegurado;
    }

    public String getDataInicioDaVigencia() {
        return dataInicioDaVigencia;
    }

    public void setDataInicioDaVigencia(String dataInicioDaVigencia) {
        this.dataInicioDaVigencia = dataInicioDaVigencia;
    }

    public String getDataFinalDaVigencia() {
        return dataFinalDaVigencia;
    }

    public void setDataFinalDaVigencia(String dataFinalDaVigencia) {
        this.dataFinalDaVigencia = dataFinalDaVigencia;
    }

    public String getNumeroEndosso() {
        return numeroEndosso;
    }

    public void setNumeroEndosso(String numeroEndosso) {
        this.numeroEndosso = numeroEndosso;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }
    
    
    public int compareTo(SeguroOnibus seguroOnibus) {
        if(this.nomeDoSegurado.compareTo(seguroOnibus.nomeDoSegurado) > 0) {
            return 1;
        } else if (this.nomeDoSegurado.compareTo(seguroOnibus.nomeDoSegurado) < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeguroOnibus)) {
            return false;
        }
        SeguroOnibus seguroOnibus = (SeguroOnibus) o;
        return this.onibus.equals(seguroOnibus.getOnibus()) && 
                (this.codigoSusep.equals(seguroOnibus.getCodigoSusep())
                || this.codigoCpdDoCorretor.equals(seguroOnibus.getCodigoCpdDoCorretor())
                || this.codigoSusepDoCorretor.equals(seguroOnibus.getCodigoSusepDoCorretor()));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigoSusepDoCorretor, codigoCpdDoCorretor, sucursalCorretor, inspetoriaDoCorretor,
                proposta, dataEmissao, apolice, sucursal, processoSusep, codigoSusep, cnpjSeguradora, nomeSeguradora,
                endereco, nomeCorretor, cpfOuCnpjDoSegurado, nomeDoSegurado, dataInicioDaVigencia, dataFinalDaVigencia,
                numeroEndosso, ramo);
    }
     
}
