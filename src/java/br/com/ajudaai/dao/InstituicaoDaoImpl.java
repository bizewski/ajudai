package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Instituicao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class InstituicaoDaoImpl extends BaseDaoImpl<Instituicao, Long> implements InstituicaoDao, Serializable{

    @Override
    public Instituicao pesquisarPorId(Long id, Session session) throws HibernateException {
    
        return (Instituicao) session.get(Instituicao.class, id);
        
    }

    @Override
    public Instituicao listarNecessidadesAtivas(Long id, Session session) throws HibernateException {

        Query query = session.createQuery("select distinct(i) from Instituicao i join fetch i.necessidades n "
                + "where n.status = true and i.id = :id");
        
        query.setParameter("id", id);
        
        return (Instituicao) query.uniqueResult();
    
    }

    @Override
    public Instituicao pesquisarPorNome(String nome, Session session) throws HibernateException{
    
        Query query = session.createQuery("from Instituicao i where i.nome like :nome");
        
        query.setParameter("nome", "%" + nome + "%");
    
        return (Instituicao) query.list();
        
    }

    @Override
    public Instituicao listarUsuarioAtivo(String login, Session session) throws HibernateException {
     
        Query query = session.createQuery("select i from Instituicao i where i.user.login = :login");
        
        query.setParameter("login", login);
        
        return (Instituicao) query.uniqueResult();
        
    }
    
}
