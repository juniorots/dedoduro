/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dedoduro.util;

import br.com.dedoduro.modelo.Usuario;
import java.util.Collection;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    
   /*
    * Gravando o usuario na sessao
    */
    public static void gravarUsuarioSessao(Usuario usuario) {
        FacesContext fc =   FacesContext.getCurrentInstance();
        HttpSession sessao = (HttpSession) fc.getExternalContext().getSession(false);
        sessao.setAttribute( "CODIGO_USUARIO", usuario.getCodigoUsuario() );
        sessao.setAttribute( "NOME_USUARIO", usuario.getNome() );
        sessao.setAttribute( "DT_NASCIMENTO_USUARIO", usuario.getDtNascimento() );
    }
    
   /*
    * Captando o usuário da sessao
    */
    public static Usuario captarUsuarioSessao() {
        Usuario usuario = null;
        ExternalContext external =  FacesContext.getCurrentInstance().getExternalContext();
        HttpSession sessao = (HttpSession) external.getSession(true);
        
        if ( !isEmpty(sessao.getAttribute("CODIGO_USUARIO") ) ) {
            usuario = new Usuario();
            usuario.setCodigoUsuario( (Long) sessao.getAttribute("CODIGO_USUARIO") );
            usuario.setNome( (String) sessao.getAttribute("NOME_USUARIO") );
            usuario.setDtNascimento( (Date) sessao.getAttribute("DT_NASCIMENTO_USUARIO") );
        }
        
        return usuario;
    }
}
