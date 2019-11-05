package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Necessidade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class NecessidadeDaoImplTest {
    
     private Necessidade necessidade;
     private NecessidadeDao necessidadeDao;
     private Session session;
    
    public NecessidadeDaoImplTest() {
        
        necessidadeDao = new NecessidadeDaoImpl();
        
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session session = null;
        NecessidadeDaoImpl instance = new NecessidadeDaoImpl();
        Necessidade expResult = null;
        Necessidade result = instance.pesquisarPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
  
    //@Test
    public void testSalvar(){
    
        //dados necessidade
        Necessidade necessidade = new Necessidade(null, "Bla bla bla", "Urgente", false);
        
       //dados instituicao
        
        Instituicao instituicao = new Instituicao();
        instituicao.setId(5L);
        
        necessidade.setInstituicao(instituicao);
        
        NecessidadeDao necessidadeDao = new NecessidadeDaoImpl();
        
        session = HibernateUtil.abreConexao();
        necessidadeDao.salvarOuAlterar(necessidade, session);
        session.close();
        
        assertNotNull(necessidade.getId());
        
    }
    
    public void ultimaNecessidadeBanco(){
    
        session = HibernateUtil.abreConexao();
        
        Query query = session.createQuery("from Necessidade");
        query.setMaxResults(1);
        
        necessidade = (Necessidade) query.uniqueResult();
        
        session.close();
        
        if(necessidade == null){
        
            testSalvar();
            
        }
    
    }
    
    @Test
    public void testAlterar(){
    
        ultimaNecessidadeBanco();
        
        session = HibernateUtil.abreConexao();
        necessidade.setStatus(false);
        
        necessidadeDao.salvarOuAlterar(necessidade, session);
    
        Necessidade necessidadeAlterada = necessidadeDao.pesquisarPorId(necessidade.getId(), session);
        
        session.close();
        
        Assert.assertEquals(necessidade.getPrioridade(), necessidadeAlterada.getPrioridade());
        
    }
    
    
}
