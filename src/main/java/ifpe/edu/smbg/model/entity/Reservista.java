package ifpe.edu.smbg.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Reservista implements Serializable {
	
        @Column (name = "numeroReservista", length = 6)
	private String numeroReservista;
        
        @Column (name = "serieReservista", length = 2)
	private String serieReservista;
        
        @Column (name = "categoriaReservista")
	private String categoriaReservista;

        public Reservista(String numeroReservista, String serieReservista, String categoriaReservista) {
            this.numeroReservista = numeroReservista;
            this.serieReservista = serieReservista;
            this.categoriaReservista = categoriaReservista;
        }
        
        public Reservista() {
            
        }

        public String getNumeroReservista() {
            return numeroReservista;
        }

        public void setNumeroReservista(String numeroReservista) {
            this.numeroReservista = numeroReservista;
        }

        public String getSerieReservista() {
            return serieReservista;
        }

        public void setSerieReservista(String serieReservista) {
            this.serieReservista = serieReservista;
        }

        public String getCategoriaReservista() {
            return categoriaReservista;
        }

        public void setCategoriaReservista(String categoriaReservista) {
            this.categoriaReservista = categoriaReservista;
        }
	
}
