package com.circleci.demo.circleci.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
	public void testRoot() throws Exception {
    String PAGE_403 = "403";
		// リクエスト呼び出して、結果を判定
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name(PAGE_403))
			.andReturn();
	}

  @Test
  public void testMainPage() throws Exception {
        this.mockMvc.perform(get("/main"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
  }

  @Test
  public void testHelloPage() throws Exception {
        this.mockMvc.perform(get("/hello"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
  }
}
