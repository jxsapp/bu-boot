package org.bu.spring.boot;

import org.bu.spring.boot.misc.BuRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuRadomTest {


	@Autowired
	private BuRandom buRandom;

	@Before
	public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(new BuRestController()).build();
	}

	@Test
	public void jsonRest() throws Exception {
		System.out.println(buRandom.toString());
	}

}
