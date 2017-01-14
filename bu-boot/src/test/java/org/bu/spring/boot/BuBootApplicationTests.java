package org.bu.spring.boot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bu.spring.boot.misc.BuAppInfo;
import org.bu.spring.boot.rest.BuRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuBootApplicationTests {

	private MockMvc mvc;

	@Autowired
	private BuAppInfo buAppInfo;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new BuRestController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/rest/hello")//
				.accept(MediaType.APPLICATION_JSON))//
				.andExpect(status().isOk())//
				.andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void jsonRest() throws Exception {
		System.out.println(buAppInfo.toString());
	}

}
