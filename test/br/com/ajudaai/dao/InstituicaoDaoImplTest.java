package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Comentario;
import br.com.ajudaai.entidade.Contato;
import br.com.ajudaai.entidade.Endereco;
import br.com.ajudaai.entidade.Evento;
import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Midia;
import br.com.ajudaai.entidade.Perfil;
import br.com.ajudaai.entidade.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class InstituicaoDaoImplTest {
    
    private Instituicao instituicao;
    private InstituicaoDao instituicaoDao;
    private Session session;
    
    public InstituicaoDaoImplTest() {
        
        instituicaoDao = new InstituicaoDaoImpl();
        
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session session = null;
        InstituicaoDaoImpl instance = new InstituicaoDaoImpl();
        Instituicao expResult = null;
        Instituicao result = instance.pesquisarPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
  
    //@Test
    public void testSalvar(){
    
        //dados instituicao
        
       Instituicao instituicao = new Instituicao(null, "Teste 12", "Teste 12", "1234","Asilo", null, null, "teste13@gmail.com", null);
       
       
        //dados endereco
        List<Endereco> enderecos = new ArrayList<>();
        
        Endereco endereco = new Endereco(null, "23256", "Mauro Ramos", 534, null, "Florianópolis", "SC");
        
        enderecos.add(endereco);
        
        instituicao.setEnderecos(enderecos);
        
        endereco.setInstituicao(instituicao);
        
        //dados contato 
        
        List<Contato> contatos = new ArrayList<>();
        
        Contato contato = new Contato(null, "31304567", null);
        
        contatos.add(contato);
        
        instituicao.setContatos(contatos);
        
        contato.setInstituicao(instituicao);
        
        //dados eventos 
        
        List<Evento> eventos = new ArrayList<>();
        
        Evento evento = new Evento(null, "Bingo", "Bla bla bla", "", "");
                
        eventos.add(evento);
        
        instituicao.setEventos(eventos);
        
        evento.setInstituicao(instituicao);
        
        //dados midias 
        
        List<Midia> midias = new ArrayList<>();
        
        Midia midia = new Midia(null, "Teste", "Teste");
        
        midias.add(midia);
        
        instituicao.setMidias(midias);
        
        midia.setInstituicao(instituicao);
        
        //dados comentario 
        
        List<Comentario> comentarios = new ArrayList<>();
        
        Comentario comentario = new Comentario(null, "Fulano", "Bla bla bla");
        
        comentarios.add(comentario);
        
        instituicao.setComentarios(comentarios);
        
        comentario.setInstituicao(instituicao);
        
        //dados usuario
        
        User user = new User(null, instituicao.getEmail(), "1234", true);
        
        Perfil perfil = new Perfil();
        perfil.setId(1L);
        
        user.setPerfil(perfil);
        instituicao.setUser(user);
        
        InstituicaoDao instituicaoDao = new InstituicaoDaoImpl();
        
        session = HibernateUtil.abreConexao();
        instituicaoDao.salvarOuAlterar(instituicao, session);
        
        session.close();
        
        assertNotNull(instituicao.getId());
        
    }
    
    //@Test
    public void listarTodos(){
    
        InstituicaoDao instituicaoDao = new InstituicaoDaoImpl();
        
        session = HibernateUtil.abreConexao();
        
        Instituicao instituicao = instituicaoDao.listarNecessidadesAtivas(5L ,session);
        
        session.close();
        
        System.out.println(instituicao);
        
    }
    
    public void ultimaInstituicaoBanco(){
    
        session = HibernateUtil.abreConexao();
        Query query = session.createQuery("from Instituicao");
        query.setMaxResults(1);
        
        instituicao = (Instituicao) query.uniqueResult();
        
        session.close();
        
        if(instituicao == null){
        
            testSalvar();
            
        }
        
    }
    
    //@Test
    public void testAlterar(){
      
       ultimaInstituicaoBanco();
      
        session = HibernateUtil.abreConexao();
        instituicao.setNome("Instituição Alterada");
        instituicaoDao.salvarOuAlterar(instituicao, session);
        
        Instituicao instituicaoAlterada = instituicaoDao.pesquisarPorId(instituicao.getId(), session);
        session.close();
        
        Assert.assertEquals(instituicao.getNome(), instituicaoAlterada.getNome());
        
         
    }
    
    //@Test
    public void testExcluir(){
    
         ultimaInstituicaoBanco();
        
        session = HibernateUtil.abreConexao();
        
        instituicaoDao.excluir(instituicao, session);
        
        Instituicao instituicaoExcluida = instituicaoDao.pesquisarPorId(instituicao.getId(), session);
        
        session.close();
        
        assertNull(instituicaoExcluida);
        
    }
}
