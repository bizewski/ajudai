package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Perfil;
import org.hibernate.Session;
import org.hibernate.HibernateException;

public interface PerfilDao extends BaseDao<Perfil,Long> {
    
    //Perfil listarUsuariosAtivos(Long id, Session session) throws HibernateException;
    
    
}
