package br.com.ajudaai.util;

public class GeradorSenha {

    public static String gerarSenha(int numero){
    
         String[] caracteres =  {"0","1","2","3","4","5","6","7","8","9",
            "a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M",
            "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String nome = "";
        int indice;
        for (int i = 0; i < numero; i++) {
            indice = (int)(Math.random() * caracteres.length);
            nome += caracteres[indice];
        }
        return nome;
        
    }
    
}
