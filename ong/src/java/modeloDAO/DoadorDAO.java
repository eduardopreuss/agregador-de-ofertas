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

import entidade.Doador;


/**
 *
 * @author 0584150
 */
public class DoadorDAO extends DAO { 
    public void inserir(Doador doador) {
		try {

			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	doador (idDoador, nome, sexo, status, tipo, cpf, rg, email, telefone, celular, cep, endereco, numero, bairro, cidade, estado, data_nascimento) values	(S_IDDOADOR.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, doador.getNome());
			pstm.setString(2, doador.getSexo());
			pstm.setString(3, doador.getStatus());
                        pstm.setString(4, doador.getTipo());
                        pstm.setString(5, doador.getCpf());
                        pstm.setString(6, doador.getRg());
                        pstm.setString(7, doador.getEmail());
                        pstm.setString(8, doador.getTelefone());
                        pstm.setString(9, doador.getCelular());
                        pstm.setString(10, doador.getCep());
                        pstm.setString(11, doador.getEndereco());
                        pstm.setString(12, doador.getNumero());
                        pstm.setString(13, doador.getBairro());
                        pstm.setString(14, doador.getCidade());
                        pstm.setString(15, doador.getEstado());
			pstm.setDate(16, doador.getDataNascimento());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			                 System.out.println("erro ao inserir: "+ e);
		}
	}
    
        public List<Doador> listar() {
        List<Doador> lista = new ArrayList<>();
        
        try {
            Connection conexao = getConexao();           
            Statement stm = conexao.createStatement();          
            ResultSet rs = stm.executeQuery("select * from doador");         
            while (rs.next()) {
                Doador doador = new Doador();
                
                doador.setBairro(rs.getString("bairro"));
                doador.setCelular(rs.getString("celular"));
                doador.setCep(rs.getString("cep"));
                doador.setCidade(rs.getString("cidade"));
                doador.setCpf(rs.getString("cpf"));
                doador.setDataNascimento(rs.getDate("data_nascimento"));
                doador.setEmail(rs.getString("email"));
                doador.setEndereco(rs.getString("endereco"));
                doador.setIdDoador(rs.getInt("iddoador"));
                doador.setNome(rs.getString("nome"));               
                doador.setNumero(rs.getString("numero"));
                doador.setRg(rs.getString("rg"));
                doador.setSexo(rs.getString("sexo"));
                doador.setStatus(rs.getString("status"));
                doador.setTelefone(rs.getString("telefone"));
                doador.setTipo(rs.getString("tipo"));
                doador.setEstado(rs.getString("estado"));
                doador.setDataNascimento(rs.getDate("data_nascimento"));
                lista.add(doador);
            }
            stm.close();
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar "+ e);
        }
        return lista;
    }
        

            
                public Doador consultar(Doador doador) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Select * from doador where iddoador =	?");
            pstm.setInt(1, doador.getIdDoador());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                 doador.setBairro(rs.getString("bairro"));
                doador.setCelular(rs.getString("celular"));
                doador.setCep(rs.getString("cep"));
                doador.setCidade(rs.getString("cidade"));
                doador.setCpf(rs.getString("cpf"));
                doador.setDataNascimento(rs.getDate("data_nascimento"));
                doador.setEmail(rs.getString("email"));
                doador.setEndereco(rs.getString("endereco"));
                doador.setIdDoador(rs.getInt("iddoador"));
                doador.setNome(rs.getString("nome"));
                doador.setNumero(rs.getString("numero"));
                doador.setRg(rs.getString("rg"));
                doador.setSexo(rs.getString("sexo"));
                doador.setStatus(rs.getString("status"));
                doador.setTelefone(rs.getString("telefone"));
                doador.setTipo(rs.getString("tipo"));
                doador.setEstado(rs.getString("estado"));
                doador.setDataNascimento(rs.getDate("data_nascimento"));
                
            }
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doador;
    }
                
                    public void alterar(Doador doador) {
        try {
            Connection conexao = getConexao();

            PreparedStatement pstmt = conexao
                    .prepareStatement("Update doador SET nome = ?,  sexo = ?, status = ?, tipo = ?, cpf = ?, rg = ?, email = ?, telefone = ?, celular = ?, cep = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, data_nascimento = ?"
                            + " WHERE iddoador = ? ");
            pstmt.setString(1, doador.getNome());
            pstmt.setString(2, doador.getSexo());
            pstmt.setString(3, doador.getStatus());
            pstmt.setString(4, doador.getTipo());
            pstmt.setString(5, doador.getCpf());
            pstmt.setString(6, doador.getRg());
            pstmt.setString(7, doador.getEmail());
            pstmt.setString(8, doador.getTelefone());
            pstmt.setString(9, doador.getCelular());
            pstmt.setString(10, doador.getCep());
            pstmt.setString(11, doador.getEndereco());
            pstmt.setString(12, doador.getNumero());
            pstmt.setString(13, doador.getBairro());
            pstmt.setString(14, doador.getCidade());
            pstmt.setString(15, doador.getEstado());
            pstmt.setDate(16, doador.getDataNascimento());           
            pstmt.setInt(17, doador.getIdDoador());
            pstmt.execute();
            pstmt.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
                    
                    public void excluir(Doador doador) {
        try {
            Connection conexao = getConexao();
            PreparedStatement pstm = conexao
                    .prepareStatement("Delete from doador where iddoador = ? ");
            pstm.setInt(1, doador.getIdDoador());
            pstm.execute();
            pstm.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 
}
