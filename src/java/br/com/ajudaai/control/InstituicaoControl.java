package br.com.ajudaai.control;

import br.com.ajudaai.dao.HibernateUtil;
import br.com.ajudaai.dao.InstituicaoDao;
import br.com.ajudaai.dao.InstituicaoDaoImpl;
import br.com.ajudaai.dao.NecessidadeDao;
import br.com.ajudaai.dao.NecessidadeDaoImpl;
import br.com.ajudaai.entidade.Comentario;
import br.com.ajudaai.entidade.Contato;
import br.com.ajudaai.entidade.Endereco;
import br.com.ajudaai.entidade.Evento;
import br.com.ajudaai.entidade.Instituicao;
import br.com.ajudaai.entidade.Midia;
import br.com.ajudaai.entidade.Necessidade;
import br.com.ajudaai.entidade.Perfil;
import br.com.ajudaai.entidade.User;
import br.com.ajudaai.util.Mensagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

@ManagedBean(name = "instituicaoC")
@ViewScoped
public class InstituicaoControl implements Serializable {

    private List<Instituicao> instituicoes;
    private List<Endereco> enderecos;
    private List<Contato> contatos;
    private List<Evento> eventos;
    private List<Midia> midias;
    private List<Necessidade> necessidades;
    private List<Comentario> comentarios;
    private InstituicaoDao instituicaoDao;
    private Instituicao instituicao;
    private Session session;
    private User user;
    private Perfil perfil;
    private Contato contato;
    private Endereco endereco;
    private Evento evento;
    private Necessidade necessidade;
    private RegistroControleUser controleUser;
    private NecessidadeDao necessidadeDao;

    public InstituicaoControl() {

    }

    public void retornarUser() {

        try {
            RegistroControleUser registroControleUser = new RegistroControleUser();
            user = registroControleUser.resgatarUsuarioSpring();

        } catch (Exception e) {
            System.out.println("Usuário não logado");
        }

        if (user != null) {

            instituicao = user.getInstituicao();
            instituicao.setUser(user);

        }

        if (instituicao.getContatos() == null) {
            instituicao.setContatos(new ArrayList<>());
        }
        contatos = instituicao.getContatos();

        if (instituicao.getEnderecos() == null) {
            instituicao.setEnderecos(new ArrayList<>());
        }
        enderecos = instituicao.getEnderecos();

        if (instituicao.getEventos() == null) {
            instituicao.setEventos(new ArrayList<>());
        }
        if (instituicao.getNecessidades() == null) {
            instituicao.setNecessidades(new ArrayList<>());
        }
    }

    public String cadastrarInstituicao() {

        session = HibernateUtil.abreConexao();

        try {

            instituicaoDao = new InstituicaoDaoImpl();
            instituicao.setUser(user);
            user.setLogin(instituicao.getEmail());
            user.setEnable(true);
            user.setPerfil(new Perfil());
            user.getPerfil().setId(1L);

            instituicaoDao.salvarOuAlterar(instituicao, session);

            instituicao = null;
            user = null;

            Mensagem.sucesso("Instituição " + instituicao.getNome());

            System.out.println("Instituição cadastrada com sucesso");

        } catch (RuntimeException e) {

            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());

        } finally {

            session.close();

        }

        return "/user/index.faces";

    }

    public String cadastrarNecessidade() {

        session = HibernateUtil.abreConexao();

        try {

            // instituicaoDao = new InstituicaoDaoImpl();
            necessidadeDao = new NecessidadeDaoImpl();
            instituicao.setNecessidades(necessidades);

            for (Necessidade necessidadeFor : necessidades) {

                necessidadeFor.setInstituicao(instituicao);
                necessidadeDao.salvarOuAlterar(necessidadeFor, session);
            }
            // instituicaoDao.salvarOuAlterar(instituicao, session);

        } catch (RuntimeException e) {

            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());

        } finally {

            session.close();

        }

        return "/user/cadastro_necessidades.faces";
    }

    public void addNecessidade() {

        usuarioLogadoSpring();

        if (necessidades == null) {
            necessidades = new ArrayList<>();
        }

        necessidades.add(necessidade);

        necessidade = new Necessidade();

    }

    private void usuarioLogadoSpring() {
        if (user == null) {

            controleUser = new RegistroControleUser();
            user = controleUser.resgatarUsuarioSpring();
            instituicao = user.getInstituicao();

            

        }
    }

    public String paginaNecessidade() {

        usuarioLogadoSpring();
        necessidadeDao = new NecessidadeDaoImpl();
        session = HibernateUtil.abreConexao();
        necessidades = necessidadeDao.pesquisarPorInstituicao(instituicao, session);
        session.close();
        return "/user/cadastro_necessidades.faces";
    }

    public String cadastraContatos() {

        session = HibernateUtil.abreConexao();

        retornarUser();

        try {

            instituicaoDao = new InstituicaoDaoImpl();

//            instituicao.setContatos(contatos);
            for (Contato contato : contatos) {

                contato.setInstituicao(instituicao);

            }

            instituicaoDao.salvarOuAlterar(instituicao, session);

        } catch (RuntimeException e) {

            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());

        } finally {

            session.close();

        }

        return "/user/cadastro_contato.faces";

    }

    public void cadastraTel() {

        retornarUser();

        contatos.add(contato);

        contato = new Contato();

    }

    public String cadastraEnderecos() {

        session = HibernateUtil.abreConexao();

        try {

            instituicaoDao = new InstituicaoDaoImpl();

            for (Endereco endereco : enderecos) {

                endereco.setInstituicao(instituicao);

            }

            instituicaoDao.salvarOuAlterar(instituicao, session);

        } catch (RuntimeException e) {

            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());

        } finally {

            session.close();

        }

        return "/user/cadastro_enderecos.faces";

    }

    public String cadastraEventos() {

        session = HibernateUtil.abreConexao();

        try {

            instituicaoDao = new InstituicaoDaoImpl();

            for (Evento evento : eventos) {

                evento.setInstituicao(instituicao);

            }

            instituicaoDao.salvarOuAlterar(instituicao, session);

        } catch (RuntimeException e) {

            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());

        } finally {

            session.close();

        }

        return "/user/cadastro_eventos.faces";

    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {

        return contatos;

    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public List<Necessidade> getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(List<Necessidade> necessidades) {
        this.necessidades = necessidades;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Instituicao getInstituicao() {
        if (instituicao == null) {

            instituicao = new Instituicao();

        }
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public User getUser() {

        if (user == null) {

            user = new User();

        }

        // TODO VERIFICAR USUARIO LOGADO
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Perfil getPerfil() {

        if (perfil == null) {

            perfil = new Perfil();
        }

        return perfil;

    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Contato getContato() {

        if (contato == null) {

            contato = new Contato();

        }

        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {

        if (endereco == null) {

            endereco = new Endereco();

        }

        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Evento getEvento() {

        if (evento == null) {

            evento = new Evento();

        }

        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Necessidade getNecessidade() {

        if (necessidade == null) {

            necessidade = new Necessidade();

        }

        return necessidade;
    }

    public void setNecessidade(Necessidade necessidade) {
        this.necessidade = necessidade;
    }

}
