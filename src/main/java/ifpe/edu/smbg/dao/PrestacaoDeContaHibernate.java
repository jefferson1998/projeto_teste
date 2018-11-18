package ifpe.edu.smbg.dao;

import java.util.List;
import javax.persistence.EntityManager;

import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.PrestacaoDeConta;

public class PrestacaoDeContaHibernate implements PrestacaoDeContaDAO {

    private EntityManager em = GeradorDeEntityManager.getEntityManager();

    public void inserir(PrestacaoDeConta prestacao) {
       try {
            em.getTransaction().begin();
            em.persist(prestacao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    public void atualizar(PrestacaoDeConta prestacao) {
       try {
            em.getTransaction().begin();
            em.merge(prestacao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    public void deletar(PrestacaoDeConta prestacao) {
       try {
            em.getTransaction().begin();
            em.remove(prestacao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

    }

    public List<PrestacaoDeConta> listarTodos() {
        List<PrestacaoDeConta> prestacoes;
        try{
            prestacoes = this.em.createQuery("from Funcionario").getResultList();
            return prestacoes;
        }catch(Exception erro) {
            prestacoes = null;
        }
        return prestacoes;
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

    public PrestacaoDeConta buscarPeloCpfDoFuncionario(String cpf) {
        PrestacaoDeConta prestacoes;
        try {
            prestacoes = (PrestacaoDeConta) em.createQuery("from PrestacaoDeConta p  JOIN Funcionario f\n" +
            "ON p.cod_funcionario = f.cod_funcionario\n" +
            "WHERE f.cpf = ?;").setParameter(1, cpf).getSingleResult();
            return prestacoes;
        } catch (Exception erro) {
            prestacoes = null;
        }
        return prestacoes;
    }

    public PrestacaoDeConta buscarPelaIdentidadeDoFuncionario(String numeroIdentidade) {
        PrestacaoDeConta prestacoes;
        try {
            prestacoes = (PrestacaoDeConta) em.createQuery("from PrestacaoDeConta p  JOIN Funcionario f\n" +
            "ON p.cod_funcionario = f.cod_funcionario\n" +
            "WHERE f.numeroIdentidade = ?;").setParameter(1, numeroIdentidade).getSingleResult();
            return prestacoes;
        } catch (Exception erro) {
            prestacoes = null;
        }
        return prestacoes;
    }

    public PrestacaoDeConta buscarPelaCnhDoFuncionario(String cnh) {
         PrestacaoDeConta prestacoes;
        try {
            prestacoes = (PrestacaoDeConta) em.createQuery("from PrestacaoDeConta p  JOIN Funcionario f\n" +
            "ON p.cod_funcionario = f.cod_funcionario\n" +
            "WHERE f.cnh = ?;").setParameter(1, cnh).getSingleResult();
            return prestacoes;
        } catch (Exception erro) {
            prestacoes = null;
        }
        return prestacoes;
    }

}
