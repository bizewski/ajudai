package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Necessidade;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class NecessidadeDaoImpl extends BaseDaoImpl<Necessidade, Long> implements NecessidadeDao, Serializable {

    @Override
    public Necessidade pesquisarPorId(Long id, Session session) throws HibernateException {

        return (Necessidade) session.get(Necessidade.class, id);

    }

    @Override
    public List<Necessidade> pesquisarPorInstituicao(Instituicao instituicao, Session session) throws HibernateException {
        Query consulta = session.createQuery("from Necessidade n where n.instituicao.id = :idInstituicao");
        consulta.setParameter("idInstituicao", instituicao.getId());

        return consulta.list();
    }

}
