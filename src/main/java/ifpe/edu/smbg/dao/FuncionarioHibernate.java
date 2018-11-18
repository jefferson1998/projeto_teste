package ifpe.edu.smbg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

import ifpe.edu.smbg.model.entity.Funcionario;

public class FuncionarioHibernate implements FuncionarioDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    public void inserir(Funcionario funcionario) {
        
        try {
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    public void atualizar(Funcionario funcionario) {

        try {
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void deletar(Funcionario funcionario) {

        try {
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios;
        try{
            funcionarios = this.em.createQuery("from Funcionario").getResultList();
        }catch(Exception erro) {
            funcionarios = null;
        }
        return funcionarios;
    }

   
    public Funcionario buscarPeloCpf(String cpf) {
        Funcionario funcionario;
        try {
            funcionario = (Funcionario) em.createQuery("from Funcionario WHERE cpf = ?").setParameter(1, cpf).getSingleResult();
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
        }
        return funcionario;
    }

    public Funcionario buscarPelaIdentidade(String numeroIdentidade) {
        Funcionario funcionario;
        try {
            funcionario = (Funcionario) em.createQuery("from Funcionario WHERE numeroidentidade = ?").setParameter(1, numeroIdentidade).getSingleResult();
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
        }
        return funcionario;

    }

    public Funcionario buscarPelaCnh(String numeroCnh) {
        Funcionario funcionario;
        try {
            funcionario = (Funcionario) em.createQuery("from Funcionario WHERE numerocnh = ?").setParameter(1, numeroCnh).getSingleResult();
            return funcionario;
        } catch (Exception erro) {
            funcionario = null;
        }
        return funcionario;
    }

}
