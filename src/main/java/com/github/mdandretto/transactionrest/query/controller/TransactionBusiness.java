package com.github.mdandretto.transactionrest.query.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.mdandretto.transactionrest.query.model.Product;
import com.github.mdandretto.transactionrest.query.model.ItemList;
import com.github.mdandretto.transactionrest.query.model.Transaction;
import com.github.mdandretto.transactionrest.query.model.Order;
import com.github.mdandretto.transactionrest.query.repository.ItemListRepository;

public class TransactionBusiness {
    
public static List<Order> getOrdersByClient(List<Transaction> transactionData, ItemListRepository itemListRepository, String codCliente)
{
    List<Order> allTransactions = new ArrayList<Order>();
        List<String> lista = new ArrayList<String>();
        for(int i = 0; i<transactionData.size(); i++)
        {
            Order tr = new Order();;
            lista.add(transactionData.get(i).getCodPedido());
            List<ItemList> itemList = null;
            for(int j = 0; j<lista.size(); j++)
            {
                itemList = itemListRepository.findByCodPedido(lista.get(j));
            }

            Product[] itVector = new Product[itemList.size()];

            for(int j = 0; j<itemList.size(); j++)
            {
                Product it = new Product();
                it.setPreco(itemList.get(j).getPreco());
                it.setProduto(itemList.get(j).getProduto());
                it.setQuantidade(itemList.get(j).getQuantidade());
                itVector[j] = it;
            }
            tr.setItem(itVector);
            tr.setCodigoPedido(transactionData.get(i).getCodPedido());
            tr.setCodigoCliente(codCliente);
            allTransactions.add(i, tr);
        }

    return allTransactions;
}

}
