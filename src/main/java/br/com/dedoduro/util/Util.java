/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.util;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Jose Alves
 */
public class Util {
    
    public static String cifrar(String texto) {
        return new Base64().encodeToString( texto.getBytes() );
    }
    
    public static String descifrar(String codigo) {
        return new String ( new Base64().decode(codigo) );
    }
}
