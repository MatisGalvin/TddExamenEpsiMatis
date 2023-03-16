package com.example.matis.tppFin.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@WebMvcTest(PierreFeuilleCiseauxController.class)
public class PierreFeuilleCiseauxControllerTest {
	
	

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_game_action_ciseaux_vs_pierre() throws Exception{
		String action = "ciseaux";
		
		MvcResult result = mockMvc.perform( get("/game/play/"+action))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
				
		String content = result.getResponse().getContentAsString();
		

		assertEquals("Vous avez jouer "+action+", l'ordinateur à joué pierre, vous avez perdu", content);
	}
	
	@Test
	public void test_game_action_pierre_pierre() throws Exception{
		String action = "pierre";
		
		MvcResult result = mockMvc.perform( get("/game/play/"+action))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
				
		String content = result.getResponse().getContentAsString();
		

		assertEquals("Vous avez jouer "+action+", l'ordinateur à joué pierre, egalité", content);
	}
	
	@Test
	public void test_game_action_feuille_pierre() throws Exception{
		String action = "pierre";
		
		MvcResult result = mockMvc.perform( get("/game/play/"+action))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
				
		String content = result.getResponse().getContentAsString();
		

		assertEquals("Vous avez jouer "+action+", l'ordinateur à joué pierre, vous avez gagné", content);
	}
	
	
}
