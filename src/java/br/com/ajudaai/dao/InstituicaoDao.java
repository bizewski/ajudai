package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Contato;
import br.com.ajudaai.entidade.Endereco;
import br.com.ajudaai.entidade.Evento;
import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Necessidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface InstituicaoDao extends BaseDao<Instituicao, Long>{

    Instituicao listarNecessidadesAtivas(Long id, Session session) throws HibernateException;
    
    Instituicao pesquisarPorNome(String nome, Session session) throws HibernateException;
    
    Instituicao listarUsuarioAtivo(String login, Session session) throws HibernateException;
    
    List<Endereco> pesquisarEnderecoInstituicaoLogado(Long idInstituicao, Session session) throws HibernateException;
    
    List<Contato> pesquisarContatoInstituicaoLogado(Long idInstituicao, Session session) throws HibernateException;
    
    List<Necessidade> pesquisarNecessidadeInstituicaoLogado(Long idInstituicao, Session session) throws HibernateException;
    
    List<Evento> pesquisarEventoInstituicaoLogado(Long idInstituicao, Session session) throws HibernateException;
    
    List<Instituicao> todasCadastradas(Session session) throws HibernateException;
    
}

