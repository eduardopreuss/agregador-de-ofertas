/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidade.Usuario;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0584150
 */
public class UsuarioDAO extends DAO {
    public String inserir(Usuario usuario) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Insert into usuario (idusuario,username, senha) values (S_USUARIO.NEXTVAL,?,?)");
            pstm.setString(1, usuario.getUsername());
            pstm.setString(2, usuario.getSenha());
            pstm.execute();
            pstm.close();
            conexao.close();
            return "";
        } 
        catch (Exception e) {
            String msg = e.getMessage();
            if(msg.contains("20000")){
                return "Este nome de usuário já está em uso!";
            }
            else if(msg.contains("20001")){
                return "Senha deve ter pelo menos 3 caracteres!";
            }
            else if(msg.contains("20002")){
                return "Usuário deve ter pelo menos 3 caracteres!";
            }
            else{
                return "Erro Desconhecido!";
            }
        }
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("Select * from usuario");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setIdusuario(rs.getInt("idusuario"));
                lista.add(usuario);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean existe(Usuario usuario) {
        boolean achou = false;
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where username =	?");
            pstm.setString(1, usuario.getUsername());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                achou = true;
            }
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return achou;
    }

    public Usuario consultar(Usuario usuario) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Select * from usuario where idusuario =	?");
            pstm.setInt(1, usuario.getIdusuario());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
              
                
            }
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    public static Usuario login(Usuario usuario) {

       
        String username = usuario.getUsername();
        String senha = usuario.getSenha();

        String searchQuery
                = "select * from usuario where username='"
                + username
                + "' AND senha='"
                + senha
                + "'";

        // pra debugar
        System.out.println("Usuario: " + username);
        System.out.println("Senha: " + senha);
        System.out.println("Consulta: " + searchQuery);

        try {
            //connect to DB
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao.prepareStatement(searchQuery);
            ResultSet rs = pstm.executeQuery();
            
            boolean more = rs.next();
            
            if (!more) {
                System.out.println("Desculpe, você não está registrado");
                usuario.setValid(false);
            } 
            else if (more) {
                String user = rs.getString("username");
                String password = rs.getString("senha");

                System.out.println("Bem vindo " + user);
                usuario.setUsername(username);
                usuario.setSenha(senha);
                usuario.setValid(true);
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (pstm != null) {
                try {
                    pstm.close();
                } catch (Exception e) {
                }
                pstm = null;
            }

            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                }

                conexao = null;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao logar: " + ex);
        } 

        return usuario;

    }


    public void alterar(Usuario usuario) {
        try {
            Connection conexao = getConexao();

            PreparedStatement pstmt = conexao
                    .prepareStatement("Update usuario SET username = ?,  senha = ?"
                            + " WHERE idusuario = ? ");
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getIdusuario());
            pstmt.execute();
            pstmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Usuario usuario) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Delete from usuario where idusuario = ? ");
            pstm.setInt(1, usuario.getIdusuario());
            pstm.execute();
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
