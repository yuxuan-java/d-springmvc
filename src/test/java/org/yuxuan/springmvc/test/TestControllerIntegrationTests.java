package org.yuxuan.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.yuxuan.springmvc.config.MyMvcConfig;
import org.yuxuan.springmvc.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
@SuppressWarnings("all")
public class TestControllerIntegrationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	MockHttpSession session;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testNormalController() throws Exception{
				
	}
	
	@Test
	public void testRestController() throws Exception{
		
	}
	
}
