package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Conta implements Serializable {
	
        @Column (name = "numeroAgencia", nullable = false, length = 4)
	private String numeroAgencia;
        
        @Column (name = "numeroConta", nullable = false, length = 10)
	private String numeroConta;
	
	public Conta(){
            
        }

        public Conta(String numeroAgencia, String numeroConta) {
            this.numeroAgencia = numeroAgencia;
            this.numeroConta = numeroConta;
        }

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
}
