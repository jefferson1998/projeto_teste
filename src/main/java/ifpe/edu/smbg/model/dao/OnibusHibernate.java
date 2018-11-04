package ifpe.edu.smbg.model.dao;

import java.util.List;
import javax.persistence.EntityManager;

import ifpe.edu.smbg.model.entity.Onibus;

public class OnibusHibernate implements OnibusDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    public OnibusHibernate() {

    }

    
    public void inserir(Onibus onibus) {

        try {
            em.getTransaction().begin();
            em.persist(onibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    
    public void atualizar(Onibus onibus) {

        try {
            em.getTransaction().begin();
            em.merge(onibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    
    public void deletar(Onibus onibus) {

        try {
            em.getTransaction().begin();
            em.remove(onibus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    
    public List<Onibus> listarTodos() {
        List<Onibus> lista;
        try {
            lista = em.createQuery("from Onibus").getResultList();
        } catch (Exception e) {
            lista = null;
        }
        return lista;
       
    }

    
    public Onibus buscarPeloOnibusPeloCodigoRenavam(String codigoRenavam) {
        Onibus onibus;
        try {
            onibus = (Onibus) em.createQuery("from Onibus WHERE codigoRenavam = ?").setParameter(1, codigoRenavam).getSingleResult();
        } catch (Exception e) {
            onibus = null;
        } 
        return onibus;
     
    }

    
    public Onibus buscarPeloOnibusChassis(String chassi) {
        Onibus onibus;
        try {
            onibus = (Onibus) em.createQuery("from Onibus WHERE chassi = ?").setParameter(1, chassi).getSingleResult();
        } catch (Exception e) {
            onibus = null;
        } 
        return onibus;
    }

    
    public Onibus buscarPelaOnibusPlaca(String placa) {
         Onibus onibus;
        try {
            onibus = (Onibus) em.createQuery("from Onibus WHERE placa = ?").setParameter(1, placa).getSingleResult();
        } catch (Exception e) {
            onibus = null;
        } 
        return onibus;
    }
}
