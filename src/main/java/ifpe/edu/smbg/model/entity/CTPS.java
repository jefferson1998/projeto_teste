package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTPS implements Serializable {
	
        @Column (name = "numeroCTPS", nullable = true, length = 7)
	private String numeroCTPS;
        
        @Column (name = "serieCTPS", nullable = true, length = 4)
	private String serieCTPS;
                
        @Column (name = "estadoCTPS", nullable = true, length = 2)
	private String estadoCTPS;
	
        public CTPS() {
            
        }

        public CTPS(String numeroCTPS, String serieCTPS, String estadoCTPS) {
            this.numeroCTPS = numeroCTPS;
            this.serieCTPS = serieCTPS;
            this.estadoCTPS = estadoCTPS;
        }
        
	public String getNumeroCTPS() {
		return numeroCTPS;
	}

	public void setNumeroCTPS(String numeroCTPS) {
		this.numeroCTPS = numeroCTPS;
	}

	public String getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(String serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public String getEstadoCTPS() {
		return estadoCTPS;
	}

	public void setEstadoCTPS(String estadoCTPS) {
		this.estadoCTPS = estadoCTPS;
	}
}
