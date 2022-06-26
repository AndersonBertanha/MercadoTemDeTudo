package DTO;

import java.util.ArrayList;
import utils.campo;

public class produtosDTO extends ClassePaiDTO {

    private campo<Integer> id_produto;
    private campo<String> descricao_produto;
    private campo<Integer> quantidade_produto;
    private campo<Double> valor;

    @Override
    public ArrayList<campo> retornaCampos() {
        ArrayList<campo> listaDeCampos = new ArrayList<>();
        listaDeCampos.add(id_produto);
        listaDeCampos.add(descricao_produto);
        listaDeCampos.add(quantidade_produto);
        listaDeCampos.add(valor);

        return listaDeCampos;
    }

    public produtosDTO() {
        this.nomeDaTabela = "produtos";
        id_produto = new campo<>();
        descricao_produto = new campo<>();
        quantidade_produto = new campo<>();
        valor = new campo<>();

        id_produto.chavePrimaria = true;
        id_produto.nomeDoCampo = "id_produto";

        descricao_produto.nomeDoCampo = "descricao_produto";
        quantidade_produto.nomeDoCampo = "quantidade_produto";
        valor.nomeDoCampo = "valor";

    }

    public campo<Integer> getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto.valorCampo = id_produto;
    }

    public campo<String> getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto.valorCampo = descricao_produto;
    }

    public campo<Integer> getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto.valorCampo = quantidade_produto;
    }

    public campo<Double> getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor.valorCampo = valor;
    }

}
