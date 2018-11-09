package ifpe.edu.smbg.dao;

import java.util.List;
import javax.persistence.EntityManager;

import ifpe.edu.smbg.model.entity.SeguroOnibus;

public class SeguroOnibusHibernate implements SeguroOnibusDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    
    public void inserir(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.persist(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public void atualizar(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.merge(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public void deletar(SeguroOnibus seguroOnibus) {
        try {
            em.getTransaction().begin();
            em.remove(seguroOnibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public List<SeguroOnibus> listarTodos() {
        
        List<SeguroOnibus> lista;
        try{
            lista = this.em.createQuery("from SeguroOnibus").getResultList();
            return lista;
        } catch (Exception erro) {
            lista = null;
        }
       return lista;
    }

    
    public SeguroOnibus buscarPeloCodigoSusepDoCorretor(int codigoSusepDoCorretor) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoSusepDoCorretor = ?").
                    setParameter(1, codigoSusepDoCorretor).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    
    public SeguroOnibus buscarPeloCodigoCpdDoCorretor(int codigoCpdDoCorretor) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoCpdDoCorretor = ?").
                    setParameter(1, codigoCpdDoCorretor).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    
    public SeguroOnibus buscarPeloCodigoSusep(int codigoSusep) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE codigoSusep = ?").
                    setParameter(1, codigoSusep).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    
    public SeguroOnibus buscarPeloCnpjDaEmpresaDoSeguro(String cpnj) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE cpnj = ?").
                    setParameter(1, cpnj).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    
    public SeguroOnibus buscarPeloCpfOuCnpjDoSegurado(String cpfOuCnpjDoSegurado) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE cpfOuCnpjDoSegurado = ?").
                    setParameter(1, cpfOuCnpjDoSegurado).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

    
    public SeguroOnibus buscarPeloNumeroEndosso(int numeroEndosso) {
        SeguroOnibus seguroOnibus;
        try {
            seguroOnibus = (SeguroOnibus) em.createQuery("from SeguroOnibus WHERE numeroEndosso = ?").
                    setParameter(1, numeroEndosso).getSingleResult();
            return seguroOnibus;
        } catch (Exception e) {
            seguroOnibus = null;
        }
        return seguroOnibus;
    }

}
