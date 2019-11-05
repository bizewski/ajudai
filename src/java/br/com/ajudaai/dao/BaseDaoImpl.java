package br.com.ajudaai.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 * @param <T>
 * @param <ID>
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{
    
    private Transaction transacao;

    @Override
    public void salvarOuAlterar(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.saveOrUpdate(entidade);
        transacao.commit();
    }

    @Override
    public void excluir(T entidade, Session session) throws HibernateException {
        transacao = session.beginTransaction();
        session.delete(entidade);
        transacao.commit();
    }
    
}
