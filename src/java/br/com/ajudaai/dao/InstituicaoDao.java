package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Instituicao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface InstituicaoDao extends BaseDao<Instituicao, Long>{

    Instituicao listarNecessidadesAtivas(Long id, Session session) throws HibernateException;
    
    Instituicao pesquisarPorNome(String nome, Session session) throws HibernateException;
    
    Instituicao listarUsuarioAtivo(String login, Session session) throws HibernateException;
    
}

