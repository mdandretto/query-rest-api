package com.github.mdandretto.transactionrest.query.model;

import java.io.Serializable;

public class Item implements Serializable{
    private String produto;
    private int quantidade;
    private float preco;
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
