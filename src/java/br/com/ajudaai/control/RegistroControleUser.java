package br.com.ajudaai.control;

import br.com.ajudaai.dao.HibernateUtil;
import br.com.ajudaai.dao.UserDao;
import br.com.ajudaai.dao.UserDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class RegistroControleUser{
    
    private br.com.ajudaai.entidade.User user;
    private Session session;
    private UserDao userDao;

    public br.com.ajudaai.entidade.User resgatarUsuarioSpring() {

        String login = resgatarLoginLogado();

        userDao = new UserDaoImpl();

        try {
            session = HibernateUtil.abreConexao();
            this.user = userDao.pesquisarPorLogin(login, session);

        } catch (HibernateException e) {

            System.out.println("Erro ao pesquisar login" + e.getMessage());

        } finally {
            session.close();
        }

        return this.user;

    }

    private String resgatarLoginLogado() {
        String login = null;
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {

            Authentication autenticacao = context.getAuthentication();

            if (autenticacao instanceof Authentication) {

                login = ((User) autenticacao.getPrincipal()).getUsername();
              
            }

        }
        return login;
    }
}
