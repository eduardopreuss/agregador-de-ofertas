/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author 0584150
 */
public class Usuario {
    private int idusuario;
    private String username;
    private String senha;
    public boolean valid;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public boolean isValid() {
       return valid;
   }

    public void setValid(boolean newValid) {
       valid = newValid;
   }   
    
    public void removeUserName() {
        username = null;
    }
    public void removePassword() {
        senha = null;
   }
    
}
