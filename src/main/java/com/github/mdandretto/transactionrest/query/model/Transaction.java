package com.github.mdandretto.transactionrest.query.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "codigo_cliente")
	private String codCliente;

    @Column(name = "codigo_pedido")
	private String codPedido;

	@Column(name = "total_ammount")
	private String totAmmount;

	public Transaction() {

	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public String getTotAmmount() {
        return totAmmount;
    }

    public void setTotAmmount(String totAmmount) {
        this.totAmmount = totAmmount;
    }

	public Transaction(String codCliente, String codPedido, String totAmmount) {
		this.codCliente = codCliente;
		this.codPedido = codPedido;
		this.totAmmount = totAmmount;
	}

}
