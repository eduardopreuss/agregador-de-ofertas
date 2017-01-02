/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Doacao;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Cristiano do Couto 
 */
public class RelatorioDAO extends DAO {
    
    //FUNCTIONS
    public List<Doacao> listarTodasDoacoes(int periodo) {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("SELECT * FROM TABLE(ListarTodasAsDoacoes(?))");
            pstm.setInt(1, periodo);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setDataDoacao(rs.getDate("DataUltimaDoacao"));
                doacao.setNomeDoador(rs.getString("NomeDoador"));
                doacao.setQuantidade(rs.getInt("QuantidadeDoada"));
                doacao.setNomeProduto(rs.getString("NomeProduto"));
                lista.add(doacao);
            }
            rs.close();
            pstm.close();
            conexao.close();
        }
        catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
    
    public List<Doacao> doacoesDoDoadorNoPeriodo(int idDoador, int periodo) {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("SELECT * FROM TABLE(DoacoesDoDoadorNoPeriodo(?, ?))");
            pstm.setInt(1, idDoador);
            pstm.setInt(2, periodo);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setDataDoacao(rs.getDate("DataUltimaDoacao"));
                doacao.setNomeDoador(rs.getString("NomeDoador"));
                doacao.setQuantidade(rs.getInt("QuantidadeDoada"));
                doacao.setNomeProduto(rs.getString("NomeProduto"));
                lista.add(doacao);
            }
            rs.close();
            pstm.close();
            conexao.close();
        }
        catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
    
    //PROCEDURES
    public List<Doacao> maioresDoadores(int periodo) {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            CallableStatement stmt = conexao.prepareCall("BEGIN MaioresDoadores(?, ?); END;");
            stmt.setInt(1, periodo);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setNomeDoador(rs.getString("NomeDoador"));
                doacao.setQuantidade(rs.getInt("QuantidadeDoacoes"));
                doacao.setDataDoacao(rs.getDate("DataUltimaDoacao"));
                lista.add(doacao);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } 
        catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
    
    public List<Doacao> quantidadeDeCadaProduto(int periodo) {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            CallableStatement stmt = conexao.prepareCall("BEGIN QuantTotalDeCadaProduto(?, ?); END;");
            stmt.setInt(1, periodo);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setProduto(rs.getInt("Id_Produto"));
                doacao.setNomeProduto(rs.getString("NomeProduto"));
                doacao.setQuantidade(rs.getInt("QuantidadeTotal"));
                doacao.setDoador(rs.getInt("QuantidadeDoacoes"));
                doacao.setDataDoacao(rs.getDate("DataUltimaDoacao"));
                lista.add(doacao);
            }
            rs.close();
            stmt.close();
            conexao.close();
        }
        catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
    
    public List<Doacao> doadoresSemDoacoes(int periodo) {
        List<Doacao> lista = new ArrayList<>();
        try {
            Connection conexao = getConexao();
            CallableStatement stmt = conexao.prepareCall("BEGIN DoadoresSemDoacoesPorPeriodo(?, ?); END;");
            stmt.setInt(1, periodo);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = ((OracleCallableStatement)stmt).getCursor(2);
            while (rs.next()) {
                Doacao doacao = new Doacao();
                doacao.setNomeDoador(rs.getString("idDoador"));
                doacao.setNomeDoador(rs.getString("NomeDoador"));
                doacao.setDataDoacao(rs.getDate("DataUltimaDoacao"));
                doacao.setQuantidade(rs.getInt("QuantidadeDoacoes"));
                lista.add(doacao);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } 
        catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }    
}
