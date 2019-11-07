package br.com.ajudaai.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instituicao")
public class Instituicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    private String descricao;
    
    @Column(nullable = false)
    private String cnpj;
  
    @Column(nullable = false)
    private String categoria;
    
    private String facebook;
    
    private String instagram;
    
    @Column(nullable = false)
    private String email;
     
    private String website;
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private User user;
    
    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
    
    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Contato> contatos;
    
    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Midia> midias;
    
    @OneToMany(mappedBy = "instituicao")
    private List<Necessidade> necessidades;
            
    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;
    
    public Instituicao() {
    }
    
    public Instituicao(Long id, String nome, String descricao, String cnpj, String categoria, String facebook, String instagram, String email, String website) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.categoria = categoria;
        this.facebook = facebook;
        this.instagram = instagram;
        this.email = email;
        this.website = website;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicao)) {
            return false;
        }
        Instituicao other = (Instituicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ajudaai.entidade.Instituicao[ id=" + id + " ]";
    }
    
}
