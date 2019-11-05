package br.com.ajudaai.dao;

import br.com.ajudaai.entidade.Comentario;
import br.com.ajudaai.entidade.Contato;
import br.com.ajudaai.entidade.Endereco;
import br.com.ajudaai.entidade.Evento;
import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Midia;
import br.com.ajudaai.entidade.Necessidade;
import br.com.ajudaai.entidade.Perfil;
import br.com.ajudaai.entidade.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Perfil.class);
            cfg.addAnnotatedClass(Instituicao.class);
            cfg.addAnnotatedClass(User.class);
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Contato.class);
            cfg.addAnnotatedClass(Evento.class);
            cfg.addAnnotatedClass(Midia.class);
            cfg.addAnnotatedClass(Necessidade.class);
            cfg.addAnnotatedClass(Comentario.class);
           
            
            cfg.configure("/br/com/ajudaai/dao/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (Throwable ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session abreConexao() {
        return sessionFactory.openSession();
    }
}
