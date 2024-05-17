package com.gab1machine.fridge.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Path;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc

class ReservationControllerTests {

	private static final String TESTED_URL = "/reservations";

	@Autowired
	private MockMvc mockMvc;
	@Test
	void whenCreateReservation() throws Exception {
		// Given
		Path input = Path.of("src", "test", "java", "resources", "inputs", "registration-creation.json");
		String body = Files.readString(input);

		// When
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(TESTED_URL)
				.content(body)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		// Then
		String expected = Files.readString(Path.of("src", "test", "java", "resources", "expectations", "created-registration.json"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(expected));

	}


}
