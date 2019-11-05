package br.com.ajudaai.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 * @param <T>
 * @param <ID>
 */
public interface BaseDao<T, ID> {
    
    void salvarOuAlterar(T entidade, Session session) 
                                       throws HibernateException;
    
    void excluir(T entidade, Session session) 
                                       throws HibernateException;

    T pesquisarPorId(Long id, Session session)
                                        throws HibernateException;
}
