package com.spring.sample.functionsample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled
class FunctionSampleApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void words() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/words")).andReturn();
		mockMvc.perform(asyncDispatch(result)).andExpect(content().string("[\"foo\",\"bar\"]"));
	}

	@Test
	public void uppercase() throws Exception {
		MvcResult result = this.mockMvc.perform(post("/uppercase").contentType(MediaType.TEXT_PLAIN).content("foo")).andReturn();
		mockMvc.perform(asyncDispatch(result)).andExpect(content().string("FOO"));
	}

	@Test
	public void lowercase() throws Exception {
		MvcResult result = this.mockMvc.perform(post("/lowercase").contentType(MediaType.TEXT_PLAIN).content("FOO")).andReturn();
		mockMvc.perform(asyncDispatch(result)).andExpect(content().string("[\"foo\"]"));
	}

	@Test
	public void lowercaseMulti() throws Exception {
		MvcResult result = this.mockMvc.perform(post("/lowercase").contentType(MediaType.APPLICATION_JSON).content("[\"FOO\"]")).andReturn();
		mockMvc.perform(asyncDispatch(result)).andExpect(content().string("[\"foo\"]"));
	}

}
