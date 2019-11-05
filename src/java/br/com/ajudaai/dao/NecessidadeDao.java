package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Necessidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface NecessidadeDao extends BaseDao<Necessidade, Long>{
 
    
    List<Necessidade> pesquisarPorInstituicao(Instituicao instituicao, Session session) throws HibernateException;
}
