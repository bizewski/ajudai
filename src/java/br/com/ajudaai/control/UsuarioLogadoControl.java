package br.com.ajudaai.control;

import br.com.ajudaai.entidade.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioLogadoControl {

    private User user; 

    public User getUser() {
        if (user == null) {
            
            RegistroControleUser registroControleUser = new RegistroControleUser();
            user = registroControleUser.resgatarUsuarioSpring();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
