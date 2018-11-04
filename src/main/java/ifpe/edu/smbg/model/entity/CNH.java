package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CNH implements Serializable {
    
        @Column (name = "numeroCNH", nullable = true)
	private String numeroCNH;
        
        @Column (name = "categoriaCNH", nullable = true)
	private String categoriaCNH;
	
        public CNH(){
            
        }

        public CNH(String numeroCNH, String categoriaCNH) {
            this.numeroCNH = numeroCNH;
            this.categoriaCNH = categoriaCNH;
        }
        
	public String getNumeroCNH() {
		return numeroCNH;
	}
	
	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
	
	public String getCategoriaCNH() {
		return categoriaCNH;
	}
	
	public void setCategoriaCNH(String categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}
}
