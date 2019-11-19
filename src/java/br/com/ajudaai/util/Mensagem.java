package br.com.ajudaai.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem { 
    
    public static void sucesso(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg + " cadastrado com sucesso!"));
    }
     
    public static void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Instituição não registrada junto ao Conselho de Assistência Social. Em breve, entraremos em contato!"));
    }
     
    public static void erro(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erro ao cadastrar!"));
    }
     
    public static void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
    
}
    
