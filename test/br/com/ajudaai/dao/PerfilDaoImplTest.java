package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Perfil;
import br.com.ajudaai.util.GeradorUtil;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;


public class PerfilDaoImplTest {

    private Perfil perfil;
    private PerfilDao perfilDao;
    private Session session;

    public PerfilDaoImplTest() {
        
        perfilDao = new PerfilDaoImpl();
        
    }

    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session session = null;
        PerfilDaoImpl instance = new PerfilDaoImpl();
        Perfil expResult = null;
        Perfil result = instance.pesquisarPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test

    public void salvar() {

        perfil = new Perfil(null, GeradorUtil.gerarNome(), GeradorUtil.gerarNome());

        session = HibernateUtil.abreConexao();
        perfilDao.salvarOuAlterar(perfil, session);
        session.close();

        assertNotNull(perfil.getId());

    }

}
