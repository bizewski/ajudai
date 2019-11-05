package br.com.ajudaai.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeradorUtil {

    public static String gerarCPF(int numero) {

        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String cpf = "";
        int indice;

        for (int i = 0; i < numero; i++) {

            indice = (int) ((int) (Math.random() * numeros.length));

            cpf += numeros[indice];

        }

        return cpf;

    }

    public static String gerarNome() {

        return gerarCPF(10);

    }

    public static String gerarCpf() {

        return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3) + "-" + gerarNumero(2);

    }

    public static String gerarEmail() {

        return gerarCPF(7) + "@email.com.br";

    }

    public static String gerarTelefone() {

        return "(" + gerarNumero(2) + ")" + gerarNumero(5) + "-" + gerarNumero(4);

    }

    public static String gerarNumero(int quantidade) {

        String numero = "";

        for (int i = 0; i < quantidade; i++) {

            numero += (int) (Math.random() * 10);

        }

        return numero;

    }
}
