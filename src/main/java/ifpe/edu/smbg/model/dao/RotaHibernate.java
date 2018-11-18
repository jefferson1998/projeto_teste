package ifpe.edu.smbg.model.dao;

import java.util.List;
import javax.persistence.EntityManager;

import ifpe.edu.smbg.model.entity.Rota;

public class RotaHibernate implements RotaDAO {

    private final EntityManager em = GeradorDeEntityManager.getEntityManager();

    public RotaHibernate() {

    }

    
    public void inserir(Rota rota) {

        try {
            em.getTransaction().begin();
            em.persist(rota);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    
    public void atualizar(Rota rota) {

        try {
            em.getTransaction().begin();
            em.merge(rota);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    
    public void deletar(Rota rota) {
        try {
            em.getTransaction().begin();
            em.remove(rota);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    
    public List<Rota> listarTodos() {
        List<Rota> lista;
        try {
            lista = em.createQuery("from Rota").getResultList();
            return lista;
        } catch (Exception erro) {
            lista = null;
        }
        return lista;
    }

    public List<Rota> buscarPelaOrigem(String origem) {
        List<Rota> lista;
        try {
            lista = em.createQuery("from Rota WHERE origem = ?").setParameter(1, origem).getResultList();
            return lista;
        } catch (Exception e) {
            lista = null;
        } 
        return lista;
    }

    
    public List<Rota> buscarPeloDestino(String destino) {
        List<Rota> lista;
        try {
            lista = em.createQuery("from Rota WHERE destino = ?").setParameter(1, destino).getResultList();
            return lista;
        } catch (Exception e) {
            lista = null;
        } 
        return lista;
    }

    
    public List<Rota> buscarPeloHorarioDeSaida(String horarioDeSaida) {
        List<Rota> lista;
        try {
            lista = em.createQuery("from Rota WHERE horarioDeSaida = ?").setParameter(1, horarioDeSaida).getResultList();
            return lista;
        } catch (Exception e) {
            lista = null;
        } 
        return lista;
    }

}
