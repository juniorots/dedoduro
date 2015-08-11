/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.util;

import java.util.Collection;
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
    
    /**
     * Verificando objeto nulo
     * @param obj
     * @return 
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String && ((String) obj).equals("") ) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).size() == 0)  {
            return true;
        } else {
            return false;
        }
    }
}
