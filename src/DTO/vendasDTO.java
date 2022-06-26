package DTO;

import java.util.ArrayList;
import utils.campo;

public class vendasDTO extends ClassePaiDTO {

    private campo<Integer> id_venda;
    private campo<Integer> fk_produto;
    private campo<Integer> fk_cliente;
    private campo<Integer> quantidade;

    @Override
    public ArrayList<campo> retornaCampos() {
        ArrayList<campo> listaDeCampos = new ArrayList<>();
        listaDeCampos.add(id_venda);
        listaDeCampos.add(fk_produto);
        listaDeCampos.add(fk_cliente);
        listaDeCampos.add(quantidade);

        return listaDeCampos;

    }
     public vendasDTO() {
        this.nomeDaTabela = "vendas";
        id_venda = new campo<>();
        fk_produto = new campo<>();
        fk_cliente = new campo<>();
        quantidade = new campo<>();

        id_venda.chavePrimaria = true;
        id_venda.nomeDoCampo = "id_venda";

        fk_produto.nomeDoCampo = "fk_produto";
        fk_cliente.nomeDoCampo = "fk_cliente";
        quantidade.nomeDoCampo = "quantidade";

    }

    public campo<Integer> getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda.valorCampo = id_venda;
    }

    public campo<Integer> getFk_produto() {
        return fk_produto;
    }

    public void setFk_produto(int fk_produto) {
        this.fk_produto.valorCampo = fk_produto;
    }

    public campo<Integer> getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente.valorCampo = fk_cliente;
    }

    public campo<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.valorCampo = quantidade;
    }

}
