package com.winston.mockito.practice;

import com.winston.mockito.practice.service.UserService;
import com.winston.mockito.practice.support.DemoTestApplication;
import com.winston.mockito.practice.support.MockBeansConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {DemoTestApplication.class, MockBeansConfig.class},
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    WebApplicationContext context;

    @Autowired
    UserService userService;

    @Test
    void testSaveUser() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        when(userService.saveUser(any())).thenReturn(999L);

        ResultActions result = mockMvc.perform(post("/user"));
        result.andExpect(status().isOk());
        MvcResult mvcResult = result.andReturn();
        System.out.println("结果是" + mvcResult.getResponse().getContentAsString());
        verify(userService, times(1)).saveUser(any());
    }

}
