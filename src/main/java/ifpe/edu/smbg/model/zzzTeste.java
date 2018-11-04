/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.smbg.model;

import ifpe.edu.smbg.model.dao.GeradorDeEntityManager;
import ifpe.edu.smbg.model.entity.Admissao;
import ifpe.edu.smbg.model.entity.Conta;
import ifpe.edu.smbg.model.entity.Endereco;
import ifpe.edu.smbg.model.entity.Funcionario;
import ifpe.edu.smbg.model.entity.Identidade;

import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;

/**
 *
 * @author Jessin
 */
public class zzzTeste {
    public static void main(String[] args) {
        
        EntityManager em = GeradorDeEntityManager.getEntityManager();

            Admissao ad = new Admissao();
            ad.setDataAdmissao("15/05/1998");
            ad.setFuncao("Motorista");
            ad.setHoras(12);
            ad.setInstrucao("Zé");
            ad.setNumeroDeFilhos(12);
            ad.setValorSalario(1200);
            
            Conta c = new Conta();
            c.setNumeroAgencia("12");
            c.setNumeroConta("15");
            ad.setConta(c);

            System.out.println("Persistiu Admissao");
            
            Identidade i = new Identidade();
            Endereco e = new Endereco("SP", 0, "Magano", "123");
            Funcionario f = new Funcionario();
            
            f.setAdmissao(ad);
            f.setCpf("125.225.945/70");
            i.setNome("José");
            i.setNumeroIdentidade("12");
            i.setNomeDaMae("Maria");
            i.setOrgaoEmissor("SDS");
            i.setDataDeEmissao("12/05/1998");
            i.setUFIdentidade("PE");
            f.setFuncionarioIdentidade(i);
            f.setFuncionarioEndereco(e);
            f.setAdmissao(ad);
            
            
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            
       
            System.out.println("Persistiu Funcionario");
           
            FuncionarioModel fm =  new FuncionarioModel();
            Funcionario f1;
            
            f1 = (Funcionario) em.createQuery("from Funcionario WHERE cpf = ?").setParameter(1, "125.225.945/70").getSingleResult();
            
            System.out.println(f1);
            
            
        
    }
}
