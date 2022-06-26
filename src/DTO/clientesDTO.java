package DTO;

import java.util.ArrayList;
import utils.campo;

public class clientesDTO extends ClassePaiDTO {

    private campo<Integer> id_cliente;
    private campo<String> nome_cliente;
    private campo<String> Cpf;
    private campo<String> telefone;
    private campo<String> email;

    public clientesDTO() {
        this.nomeDaTabela="clientes";
        id_cliente = new campo<>();
        nome_cliente = new campo<>();
        Cpf = new campo<>();
        telefone = new campo<>();
        email = new campo<>();
        id_cliente.chavePrimaria= true;
        id_cliente.nomeDoCampo="id_cliente";
        nome_cliente.nomeDoCampo="nome_cliente";
        Cpf.nomeDoCampo="cpf";
        telefone.nomeDoCampo="telefone";
        email.nomeDoCampo= "email";

    }

    @Override
    public ArrayList<campo> retornaCampos() {
        ArrayList<campo> listaDeCampos = new ArrayList<>();
        listaDeCampos.add(id_cliente);
        listaDeCampos.add(nome_cliente);
        listaDeCampos.add(Cpf);
        listaDeCampos.add(telefone);
        listaDeCampos.add(email);

        return listaDeCampos;
    }

    public campo<Integer> getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente.valorCampo = id_cliente;
    }

    public campo<String> getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente.valorCampo = nome_cliente;
    }

    public campo<String> getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf.valorCampo = Cpf;
    }

    public campo<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.valorCampo = telefone;
    }

    public campo<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.valorCampo = email;
    }

}
