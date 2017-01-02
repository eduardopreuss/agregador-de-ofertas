/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.Produto;

/**
 *
 * @author 0573159
 */
public class ProdutoDAO extends DAO {

    public void inserir(Produto produto) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Insert into ongProduto (id_produto,nome, tipo, peso) values (S_IDPRODUTO.NEXTVAL,?,?,?)");
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getTipo());
            pstm.setFloat(3, produto.getPeso());
            pstm.execute();
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("Select * from ongProduto");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setPeso(rs.getFloat("peso"));
                produto.setTipo(rs.getString("tipo"));
                produto.setId_produto(rs.getInt("id_produto"));
                lista.add(produto);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



    public Produto consultar(Produto produto) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Select * from ongProduto where id_produto =	?");
            pstm.setInt(1, produto.getId_produto());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                produto.setNome(rs.getString("nome"));
                produto.setPeso(rs.getFloat("peso"));
                produto.setTipo(rs.getString("tipo"));
                
            }
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    public void alterar(Produto produto) {
        try {
            Connection conexao = getConexao();

            PreparedStatement pstmt = conexao
                    .prepareStatement("Update ongProduto SET nome = ?,  tipo = ?, peso = ?"
                            + " WHERE id_produto = ? ");
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getTipo());
            pstmt.setFloat(3, produto.getPeso());
            pstmt.setInt(4, produto.getId_produto());
            pstmt.execute();
            pstmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Produto produto) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Delete from ongProduto where id_produto = ? ");
            pstm.setInt(1, produto.getId_produto());
            pstm.execute();
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
