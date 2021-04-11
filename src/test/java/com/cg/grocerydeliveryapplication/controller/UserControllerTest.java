package com.cg.grocerydeliveryapplication.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cg.grocerydeliveryapplication.domain.User;
import com.cg.grocerydeliveryapplication.repository.UserRepository;
import com.cg.grocerydeliveryapplication.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value =UserController.class)
public class UserControllerTest {

	  @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private UserService userService;
	    @MockBean
	    private UserRepository userRepository ;

	    @Test
	    public void testREgistrationForm() throws Exception {
	    	String URI= "/grocery/register";
	    	User user1 = new User();
			user1.setuId(4);
			user1.setfName("Gunjan");
			user1.setlName("Sharma");
			user1.setPassword("gunjan123");
			user1.setAddress("xyz lane");
			user1.setEmail("gunjan@gmail.com");
			user1.setpNumber(985624785);
			user1.setUserName("Gunsha");
			 String jsonInput = this.converttoJson(user1);
			 Mockito.when(userService.registerationForm(Mockito.any(User.class))).thenReturn(user1);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
		                .andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();
		        assertThat(jsonInput).isEqualTo(jsonOutput);
		    
	    }

		private String converttoJson(User user1) throws JsonProcessingException {
			   ObjectMapper objectMapper = new ObjectMapper();
		        return objectMapper.writeValueAsString(user1);
		}
	  
}
