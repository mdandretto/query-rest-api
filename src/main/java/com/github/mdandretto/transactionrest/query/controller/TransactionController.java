package com.github.mdandretto.transactionrest.query.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mdandretto.transactionrest.query.model.Product;
import com.github.mdandretto.transactionrest.query.model.ItemList;
import com.github.mdandretto.transactionrest.query.model.Transaction;
import com.github.mdandretto.transactionrest.query.model.Order;
import com.github.mdandretto.transactionrest.query.repository.ItemListRepository;
import com.github.mdandretto.transactionrest.query.repository.TransactionRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	ItemListRepository itemListRepository;

	//a. Valor total do pedido
	@GetMapping("/valortotalpedido/{codPedido}")
	public ResponseEntity<String> getTransactionById(@PathVariable("codPedido") String codPedido) {
		Optional<Transaction> transactionData = transactionRepository.findByCodPedido(codPedido);

		if (transactionData.isPresent()) {
			return new ResponseEntity<String>(transactionData.get().getTotAmmount(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//b. Quantidade de pedidos por Cliente
	@GetMapping("/pedidoporcliente/{codCliente}")
	public ResponseEntity<String> getTransactionByCodCliente(@PathVariable("codCliente") String codCliente) {
		List<Transaction> transactionData = transactionRepository.findByCodCliente(codCliente);

		if (transactionData.size() > 0) {
			String ocurrences = String.valueOf(transactionData.size());
			return new ResponseEntity<String>(ocurrences, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//c. Lista de pedidos realizados por cliente
	@GetMapping("/listadepedidos/{codCliente}")
	public ResponseEntity<List<Order>> getPedidoByCodCliente(@PathVariable("codCliente") String codCliente) {
		List<Transaction> transactionData = transactionRepository.findByCodCliente(codCliente);

		if (transactionData.size() > 0) {
			List<Order> allTransactions = TransactionBusiness.getOrdersByClient(transactionData, itemListRepository, codCliente);
			return new ResponseEntity<List<Order>>(allTransactions, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
