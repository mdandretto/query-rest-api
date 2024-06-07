package com.github.mdandretto.transactionrest.query.model;

import java.io.Serializable;


public class TransactionList implements Serializable {
    private String codigoPedido;
    private String codigoCliente;
    public String getCodigoPedido() {
        return codigoPedido;
    }
    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    public String getCodigoCliente() {
        return codigoCliente;
    }
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    public Item[] getItem() {
        return item;
    }
    public void setItem(Item[] item) {
        this.item = item;
    }
    private Item[] item;
}
