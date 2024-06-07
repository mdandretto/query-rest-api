package com.github.mdandretto.transactionrest.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.mdandretto.transactionrest.query.model.ItemList;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
  List<ItemList> findByCodPedido(String codPedido);
}