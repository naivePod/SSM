package com.lgs.AOP;

import com.lgs.controller.ConfigController;
import com.lgs.service.IHelloService;
import com.lgs.service.impl.HelloService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class Test extends BaseTest {
    private MockMvc mockMvc;



    @Before
    public void setup() {
        ConfigController configController = new ConfigController();
        mockMvc = MockMvcBuilders.standaloneSetup(configController).build();
    }

    @org.junit.Test
    public void testBefore() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IHelloService iHelloService = context.getBean("helloService", IHelloService.class);

        iHelloService.sayAfterReturning();

        ConfigController configController = context.getBean("configController", ConfigController.class);
        configController.sayHello();
    }

    @org.junit.Test
    public void demo() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/config/say"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        System.out.println("请求状态码：" + status);
//        String result = mvcResult.getResponse().getContentAsString();
//        System.out.println("接口返回结果：" + result);
    }


}
