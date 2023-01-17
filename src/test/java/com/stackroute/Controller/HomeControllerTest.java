package com.stackroute.Controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.stackroute.model.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class HomeControllerTest {
private MockMvc mockMvc;

@InjectMocks
private HomeController homeController;

@MockBean
private Employee empRepo;

@BeforeAll
public void initialSetUp() {
	MockitoAnnotations.initMocks(this);	
}

}
