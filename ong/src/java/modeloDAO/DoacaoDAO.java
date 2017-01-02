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

import entidade.Doacao;
import entidade.Doador;
import entidade.Produto;

/**
 *
 * @author 0573159
 */
public class DoacaoDAO extends DAO {

    public String inserir(Doacao doacao) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Insert into doacao (id_doacao,doador, produto, quantidade, dataVal, dataDoacao) values (S_ID_DOACAO.NEXTVAL,?,?,?,?,?)");
            pstm.setInt(1, doacao.getDoador());
            pstm.setInt(2, doacao.getProduto());
            pstm.setInt(3, doacao.getQuantidade());
            pstm.setDate(4, doacao.getDataVal());
            pstm.setDate(5, doacao.getDataDoacao());
            pstm.execute();
            pstm.close();
            conexao.close();
            return "";
        } 
        catch (Exception e) {
            String msg = e.getMessage();
            if(msg.contains("20000")){
                return "Quantidade Inválida!";
            }
            else if(msg.contains("20001")){
                return "Data de Doação Inválida!";
            }
            else if(msg.contains("20002")){
                return "Data de Validade deve ser maior que a Data de Doação!";
            }
            else if(msg.contains("20003")){
                return "Produto está fora do prazo de validade!";
            }
            else{
                return "Erro Desconhecido!";
            }
        }
    }

    public List<Doacao> listar() {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("select dr.nome doador_nome, p.nome produto_nome, do.quantidade, do.dataval, do.datadoacao, do.id_doacao from doacao do join doador dr on do.doador = dr.iddoador join ongproduto p on do.produto = p.id_produto");
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setNomeDoador(rs.getString("doador_nome"));
                doacao.setNomeProduto(rs.getString("produto_nome"));
                doacao.setQuantidade(rs.getInt("quantidade"));
                doacao.setDataVal(rs.getDate("dataval"));
                doacao.setDataDoacao(rs.getDate("datadoacao"));
                doacao.setId_doacao(rs.getInt("id_doacao"));
                lista.add(doacao);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
    
    public List<Doador> listarDoador() {
        List<Doador> listaDoador = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("select iddoador, nome from doador");
            while (rs.next()) {
                Doador doador = new Doador();
                doador.setIdDoador(rs.getInt("iddoador"));
                doador.setNome(rs.getString("nome"));
                
                listaDoador.add(doador);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return listaDoador;
    }
    
    public List<Produto> listarProduto() {
        List<Produto> listaProduto = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            Statement stm = conexao.createStatement();
            ResultSet rs = stm.executeQuery("select id_produto, nome from ongProduto");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                
                listaProduto.add(produto);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return listaProduto;
    }

    public Doacao consultar(Doacao doacao) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Select * from doacao where id_doacao =	?");
            pstm.setInt(1, doacao.getId_doacao());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                
                doacao.setDoador(rs.getInt("doador"));
                doacao.setProduto(rs.getInt("produto"));
                doacao.setQuantidade(rs.getInt("quantidade"));
                doacao.setDataVal(rs.getDate("dataVal"));
                doacao.setDataDoacao(rs.getDate("dataDoacao"));
                
            }
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doacao;
    }

    public void alterar(Doacao doacao) {
        try {
            Connection conexao = getConexao();

            PreparedStatement pstmt = conexao
                    .prepareStatement("Update doacao SET doador = ?,  produto = ?, quantidade = ?, dataVal = ?, dataDoacao = ?"
                            + " WHERE id_doacao = ? ");
            pstmt.setInt(1, doacao.getDoador());
            pstmt.setInt(2, doacao.getProduto());
            pstmt.setInt(3, doacao.getQuantidade());
            pstmt.setDate(4, doacao.getDataVal());
            pstmt.setDate(5, doacao.getDataDoacao());
            pstmt.setInt(6, doacao.getId_doacao());
            
            pstmt.execute();
            pstmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Doacao doacao) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Delete from doacao where id_doacao = ? ");
            pstm.setInt(1, doacao.getId_doacao());
            pstm.execute();
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
