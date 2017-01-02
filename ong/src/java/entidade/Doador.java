/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 0584150
 */
public class Doador {

    
    
    private int idDoador;
    private String nome;
    private String sexo;
    private String status;
    private String tipo;
    private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String celular;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Date data_nascimento;
    
    
    public Date data;

    public Doador() {
    }
     

    public Doador(int idDoador, String nome, String sexo, String status, String tipo, String cpf, String rg, String email, String telefone, String celular, String cep, String endereco, String numero, String bairro, String cidade, String estado, Date data_nascimento) {
        this.idDoador = idDoador;
        this.nome = nome;
        this.sexo = sexo;
        this.status = status;
        this.tipo = tipo;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.data_nascimento = data_nascimento;
    }
    
    
    
    
    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Date getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.data_nascimento = dataNascimento;
    }
    
     
    
}


    