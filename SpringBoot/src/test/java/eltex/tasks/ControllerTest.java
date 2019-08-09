package eltex.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	private  ArrayList<User> users = new ArrayList<User>();
	@Autowired
	private UserController controller;

	@Test
	public void contextLoads() throws Exception {
		org.assertj.core.api.Assertions.assertThat(controller).isNotNull();
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public  void create() throws Exception {

        String expected = "Users has create";

        this.mockMvc.perform(get("http://localhost:8090/create")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(expected)));

	}

	@Test
	public  void clear() throws Exception {

		String expected = "Users has removed from list";

		this.mockMvc.perform(get("http://localhost:8090/clear")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(expected)));
	}

	@Test
	public void getUsers() throws Exception {

		create();

		users.add(new User(1, "Alexey", "900"));
		users.add(new User(2, "Gena", "800"));
		users.add(new User(3, "Eugene", "700"));
		users.add(new User(4, "Venc", "600"));

		ObjectMapper mapper = new ObjectMapper();
		String expected = null;

		if (!users.isEmpty())
            expected =  mapper.writeValueAsString(users);
        else
            expected = "Users not found";

		this.mockMvc.perform(get("http://localhost:8090/get_users")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(expected)));
	}

	@Test
	public void getUser() throws Exception {

		create();

		ObjectMapper mapper = new ObjectMapper();
		String expected = null;
		users.add(new User(1, "Alexey", "900"));

      if (!users.isEmpty())
            expected =  mapper.writeValueAsString(users.get(0));
        else
            expected = "Current user not found";

		this.mockMvc.perform(get("http://localhost:8090/get_user/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(expected)));
	}
}