package com.cg.grocerydeliveryapplication.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.cg.grocerydeliveryapplication.domain.User;
import com.cg.grocerydeliveryapplication.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@MockBean
	public UserRepository userRepository;
	
	@Autowired
	 private UserService userService;

	@Test
	public void testRegistrationForm() {
		User user1 = new User();
		user1.setuId(4);
		user1.setfName("Gunjan");
		user1.setlName("Sharma");
		user1.setPassword("gunjan123");
		user1.setAddress("xyz lane");
		user1.setEmail("gunjan@gmail.com");
		user1.setpNumber(985624785);
		user1.setUserName("Gunsha");
		 Mockito.when(userRepository.save(user1)).thenReturn((user1));
		 assertThat(userService.resgisterationForm(user1)).isEqualTo(user1);	 
	}
	
	
}
