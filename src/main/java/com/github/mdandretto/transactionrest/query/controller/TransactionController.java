package com.github.mdandretto.transactionrest.query.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.mdandretto.transactionrest.query.model.Transaction;
import com.github.mdandretto.transactionrest.query.repository.TransactionRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(@RequestParam(required = false) String codCliente) {
		try {
			List<Transaction> transactions = new ArrayList<Transaction>();

			if (codCliente == null)
				transactionRepository.findAll().forEach(transactions::add);
			else
				transactionRepository.findByCodCliente(codCliente).forEach(transactions::add);

			if (transactions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(transactions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long id) {
		Optional<Transaction> transactionData = transactionRepository.findById(id);

		if (transactionData.isPresent()) {
			return new ResponseEntity<>(transactionData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pedido/{codPedido}")
	public ResponseEntity<String> getTransactionById(@PathVariable("codPedido") String codPedido) {
		Optional<Transaction> transactionData = transactionRepository.findByCodPedido(codPedido);

		if (transactionData.isPresent()) {
			return new ResponseEntity<String>(transactionData.get().getTotAmmount(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cliente/{codCliente}")
	public ResponseEntity<String> getTransactionByCodCliente(@PathVariable("codCliente") String codCliente) {
		List<Transaction> transactionData = transactionRepository.findByCodCliente(codCliente);

		if (transactionData.size() > 0) {
			String ocurrences = String.valueOf(transactionData.size());
			return new ResponseEntity<String>(ocurrences, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pedidoporcliente/{codCliente}")
	public ResponseEntity<List<String>> getPedidoByCodCliente(@PathVariable("codCliente") String codCliente) {
		List<Transaction> transactionData = transactionRepository.findByCodCliente(codCliente);

		if (transactionData.size() > 0) {
			List<String> lista = new ArrayList<String>();
			for(int i = 0; i<transactionData.size(); i++)
			{
				lista.add(transactionData.get(i).getCodPedido());
			}
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
