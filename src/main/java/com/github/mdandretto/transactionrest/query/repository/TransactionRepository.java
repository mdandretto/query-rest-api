package com.github.mdandretto.transactionrest.query.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mdandretto.transactionrest.query.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findByCodCliente(String codCliente);
  Optional<Transaction> findByCodPedido(String codPedido);
  List<Transaction> findByTotAmmount(String totAmmount);
}