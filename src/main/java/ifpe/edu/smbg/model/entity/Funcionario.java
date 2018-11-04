package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import ifpe.edu.smbg.model.Persistivel;

@Entity
@Table(name = "Funcionario")
@AttributeOverride(name = "id", column = @Column(name = "Cod_Funcionario"))
public class Funcionario extends Persistivel implements Serializable, Comparable<Funcionario> {

    @Column(name = "senhadousuario", length = 20)
    private String senha;
    
    @Embedded
    private Identidade funcionarioIdentidade;

    @Column(name = "cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    @Embedded
    private Endereco funcionarioEndereco;

    @Embedded
    private CNH funcionarioCNH;

    @Column(name = "pis", nullable = true, unique = false)
    private String pis;

    @Embedded
    private Titulo funcionarioTitulo;

    @Embedded
    private CTPS funcionarioCTPS;

    @Embedded
    private Reservista funcionarioReservista;
    
    @Column(name = "emailfuncionario")
    private String emailfuncionario;
    
    @Column(name = "telefonefuncionario ")
    private String telefonefuncionario;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @JoinColumn(name = "Cod_admissao", referencedColumnName = "Cod_Admissao")
    @OneToOne(cascade = CascadeType.ALL)
    private Admissao admissao;

    public Funcionario() {
        funcionarioIdentidade = new Identidade();
        funcionarioEndereco = new Endereco();
        funcionarioCNH = new CNH();
        funcionarioTitulo = new Titulo();
        funcionarioCTPS = new CTPS();
        funcionarioReservista = new Reservista();
        admissao = new Admissao();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        
        this.senha = senha;
    }

    public Identidade getFuncionarioIdentidade() {
        return funcionarioIdentidade;
    }

    public void setFuncionarioIdentidade(Identidade funcionarioIdentidade) {
        this.funcionarioIdentidade = funcionarioIdentidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getFuncionarioEndereco() {
        return funcionarioEndereco;
    }

    public void setFuncionarioEndereco(Endereco funcionarioEndereco) {
        this.funcionarioEndereco = funcionarioEndereco;
    }

    public CNH getFuncionarioCNH() {
        return funcionarioCNH;
    }

    public void setFuncionarioCNH(CNH funcionarioCNH) {
        this.funcionarioCNH = funcionarioCNH;
    }

    public String getPIS() {
        return pis;
    }

    public void setPIS(String pIS) {
        pis = pIS;
    }

    public Titulo getFuncionarioTitulo() {
        return funcionarioTitulo;
    }

    public void setFuncionarioTitulo(Titulo funcionarioTitulo) {
        this.funcionarioTitulo = funcionarioTitulo;
    }

    public CTPS getFuncionarioCTPS() {
        return funcionarioCTPS;
    }

    public void setFuncionarioCTPS(CTPS funcionarioCTPS) {
        this.funcionarioCTPS = funcionarioCTPS;
    }

    public void setFuncionarioReservista(Reservista funcionarioReservista) {
        this.funcionarioReservista = funcionarioReservista;
    }

    public Reservista getFuncionarioReservista() {
        return funcionarioReservista;
    }


    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public Admissao getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Admissao admissao) {
        this.admissao = admissao;
    }

   
    public int compareTo(Funcionario funcionario) {
        if (this.funcionarioIdentidade.getNome().compareTo(funcionario.funcionarioIdentidade.getNome()) != 0) {
            return this.funcionarioIdentidade.getNome().compareTo(funcionario.funcionarioIdentidade.getNome());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Funcionario)) {
            return false;
        }

        Funcionario funcionario = (Funcionario) o;
        return this.cpf.equals(funcionario.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, estadoCivil, funcionarioIdentidade.getNumeroIdentidade(),
                funcionarioIdentidade.getNome(), funcionarioIdentidade.getDataDeEmissao(),
                funcionarioIdentidade.getOrgaoEmissor(), funcionarioIdentidade.getNomeDaMae(),
                funcionarioIdentidade.getUFIdentidade(), funcionarioEndereco);
    }

    public String getEmailfuncionario() {
        return emailfuncionario;
    }

    public void setEmailfuncionario(String emailfuncionario) {
        this.emailfuncionario = emailfuncionario;
    }

    public String getTelefonefuncionario() {
        return telefonefuncionario;
    }

    public void setTelefonefuncionario(String telefonefuncionario) {
        this.telefonefuncionario = telefonefuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "senha=" + senha + ", funcionarioIdentidade=" + funcionarioIdentidade + ", cpf=" + cpf + ", funcionarioEndereco=" + funcionarioEndereco + ", funcionarioCNH=" + funcionarioCNH + ", pis=" + pis + ", funcionarioTitulo=" + funcionarioTitulo + ", funcionarioCTPS=" + funcionarioCTPS + ", funcionarioReservista=" + funcionarioReservista + ", emailfuncionario=" + emailfuncionario + ", telefonefuncionario=" + telefonefuncionario + ", estadoCivil=" + estadoCivil + ", admissao=" + admissao + '}';
    }
    
    

}
