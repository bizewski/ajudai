package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Perfil;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PerfilDaoImpl extends BaseDaoImpl<Perfil, Long> implements PerfilDao, Serializable{

    @Override
    public Perfil pesquisarPorId(Long id, Session session) throws HibernateException {

        return(Perfil)session.get(Perfil.class, id);
        
    }

 
    
}
