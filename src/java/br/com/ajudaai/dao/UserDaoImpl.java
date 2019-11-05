package br.com.ajudaai.dao;

import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.ajudaai.entidade.User;
import org.hibernate.HibernateException;

public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao, Serializable {

    @Override
    public User pesquisarPorLogin(String login, Session session) {

        Query consulta = session.createQuery("from User where login = :login");

        consulta.setParameter("login", login);

        return (User) consulta.uniqueResult();

    }

    @Override
    public User pesquisarPorId(Long id, Session session) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
