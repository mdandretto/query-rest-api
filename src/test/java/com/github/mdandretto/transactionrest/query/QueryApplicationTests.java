package com.github.mdandretto.transactionrest.query;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.mdandretto.transactionrest.query.controller.TransactionController;
import com.github.mdandretto.transactionrest.query.model.Transaction;
import com.github.mdandretto.transactionrest.query.repository.ItemListRepository;
import com.github.mdandretto.transactionrest.query.repository.TransactionRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TransactionController.class)
@WithMockUser
public class QueryApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionRepository transactionRepository;

	@MockBean
	private ItemListRepository itemListRepository;

	Optional<Transaction> mockTransaction = Optional.of(new Transaction("1", "1001", "2.1"));

	@Test
	public void testGetTotalValue() throws Exception{

		long codPedido = 1001;

		Mockito.when(transactionRepository.findByCodPedido(Mockito.anyString())).thenReturn(mockTransaction);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"http://localhost:8090/api/valortotalpedido/{codPedido}", codPedido).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		

		System.out.println("TEST INITIALIZING...");
		System.out.println(result.getResponse().getStatus());
		String expected = "2.1";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		System.out.println("TESTE ENDING...");
	}

}
