package br.com.ajudaai.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
    
    
    private SimpleEmail email;

    private final String user = "ajudai.suporte@gmail.com";
    private final String password = "dgiibozrkhfpwffz";
//    private final String receiver = "e_kempfer@hotmail.com";
    private final String header = "";
    private final String footer = "Atensiosamente,\n Ajudaí";

    public EnviarEmail(){
    
        email = new SimpleEmail();
        
    }
    
    public void enviaEmail(String receiver, String subject, String message) {

        try {

            email.setDebug(true);
            //Gmail
            email.setHostName("smtp.gmail.com");
            email.setAuthentication(user, password);
            email.setSSL(true);
            email.setSubject(subject);
            email.setMsg(header + "\n" + message + "\n" + footer);
            email.send();

        } catch (EmailException e) {

            System.out.println(e.getMessage());

        }
    }
    
     public SimpleEmail getEmail() {
        return email;
    }

    public void setEmail(SimpleEmail email) {
        this.email = email;
    }

    
}
