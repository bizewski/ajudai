package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface UserDao extends BaseDao<User, Long>{
    
    User pesquisarPorLogin(String login, Session session) throws HibernateException;
    
    
}
