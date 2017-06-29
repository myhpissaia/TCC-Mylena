/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;


public class Criptografia {

    private static MessageDigest md = null;//Método para geração do algoritmo

    static {

        try {
            md = MessageDigest.getInstance("MD5");//Método getInstance da classe MessageDigest
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();

        }
    }

    private static char[] hexCodes(byte[] text) {//Método para gerar a chave

        char[] hexOutput = new char[text.length * 2];

        String hexString;

        for (int i = 0; i < text.length; i++) {

            hexString = "00" + Integer.toHexString(text[i]);

            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);

        }

        return hexOutput;

    }

    public static String criptografar(String pwd) {//Método para criptografar texto

        if (md != null) {

            return new String(hexCodes(md.digest(pwd.getBytes())));

        }

        return null;

    }

}
