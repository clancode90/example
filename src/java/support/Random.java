/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import org.springframework.stereotype.Component;

/**
 *
 * @author Юрий
 */
@Component
public class Random {

    public static String getString(String sequence, int lenght) {
        String res = "";
        java.util.Random rng= new java.util.Random();   
        char[] text = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            text[i] = sequence.charAt(rng.nextInt(sequence.length()));
        }
        res=new String(text);
        return res;
    }
    
}
