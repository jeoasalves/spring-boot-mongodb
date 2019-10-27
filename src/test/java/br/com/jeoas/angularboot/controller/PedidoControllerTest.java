package br.com.jeoas.angularboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(PedidoController.class)
public class PedidoControllerTest {

	@Autowired
    private MockMvc mvc;
	
    @Test
    public void givenClientes_whenGetClientes_thenReturnJsonArray()
      throws Exception {
        mvc.perform(MockMvcRequestBuilders
        	      .get("localhost:8080/clientes")
        	      .accept(MediaType.APPLICATION_JSON))
        	      .andDo(print())
        	      .andExpect(status().isOk());
    }
}
