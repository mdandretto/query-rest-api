package com.github.mdandretto.transactionrest.query.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_list")
public class ItemList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "codigo_pedido")
	private String codPedido;

	@Column(name = "preco")
	private float preco;

    @Column(name = "produto")
	private String produto;

    @Column(name = "quantidade")
	private int quantidade;

    public ItemList()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }
    
    public void setProduto(String produto) {
        this.produto = produto;
    }

	public ItemList(String codPedido, float preco, String produto, int quantidade) {
		this.codPedido = codPedido;
		this.preco = preco;
		this.produto = produto;
        this.quantidade = quantidade;
	}

}
