package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Necessidade;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class NecessidadeDaoImpl extends BaseDaoImpl<Necessidade, Long> implements NecessidadeDao, Serializable{

    @Override
    public Necessidade pesquisarPorId(Long id, Session session) throws HibernateException {
   
         return (Necessidade) session.get(Necessidade.class, id);
    
    }
    
}
