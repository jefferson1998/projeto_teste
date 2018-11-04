package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Titulo implements Serializable {
	
        @Column (name = "numeroTitulo", nullable = true, length = 12)
	private String numeroTitulo;
        
        @Column (name = "zonaTitulo", nullable = true)
	private int zonaTitulo;
        
        @Column (name = "secaoTitulo", nullable = true)
	private int secaoTitulo;

        public Titulo(String numeroTitulo, int zonaTitulo, int secaoTitulo) {
            this.numeroTitulo = numeroTitulo;
            this.zonaTitulo = zonaTitulo;
            this.secaoTitulo = secaoTitulo;
        }
        
	public Titulo(){
            
        }

	public String getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public int getZonaTitulo() {
		return zonaTitulo;
	}

	public void setZonaTitulo(int zonaTitulo) {
		this.zonaTitulo = zonaTitulo;
	}

	public int getSecaoTitulo() {
		return secaoTitulo;
	}

	public void setSecaoTitulo(int secaoTitulo) {
		this.secaoTitulo = secaoTitulo;
	}
}
