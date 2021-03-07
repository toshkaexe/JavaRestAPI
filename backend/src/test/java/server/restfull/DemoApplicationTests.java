package server.restfull;

import javax.swing.Spring;
import javax.swing.text.AbstractDocument.Content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.PrettyPrinter;

import ch.qos.logback.core.status.Status;
import server.restfull.controller.UserController;
import server.restfull.dao.UserDaoImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserController controller;

	@Test
	public void contentHomePage() throws Exception {
		this.mockMvc.perform(get("/"))//
				.andDo(print())//
				.andExpect(status().isOk()) //
				.andExpect(content().string(containsString("Hello")));

	}

	@Test
	public void usersPage() throws Exception {
		this.mockMvc.perform(get("/users"))//
				.andDo(print())//
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("[{\"id\":\"187\",\"firstName\":\"Donald\",\"lastName\":\"Tramp\",\"email\":\"Donald.trump@gmail.com\"},{\"id\":\"1\",\"firstName\":\"Ram\",\"lastName\":\"BobM34\",\"email\":\"ram@gmail.com\"},{\"id\":\"44\",\"firstName\":\"Andreas\",\"lastName\":\"Son\",\"email\":\"h2@gmail.com\"},{\"id\":\"55\",\"firstName\":\"Silvester\",\"lastName\":\"Piera\",\"email\":\"b2@gmail.com\"}]"))); //
		// .andExpect(xpath("//*[@id='navbarSupportedContent']/div").string("dru"));
	}

}
