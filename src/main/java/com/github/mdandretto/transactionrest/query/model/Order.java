package com.github.mdandretto.transactionrest.query.model;

public class Order {
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
    public Product[] getItem() {
        return item;
    }
    public void setItem(Product[] item) {
        this.item = item;
    }
    private Product[] item;
}
