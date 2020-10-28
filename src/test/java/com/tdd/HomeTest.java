package com.tdd;

import com.tdd.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeTest {

    HomeController controller = new HomeController();

    @Autowired
    private MockMvc mvc;


    // Testing web endpoints; the result wait test should OK === 200 & json content
    @Test
    public void testList() throws Exception{
        this.mvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // Testing hello world
    @Test
    public void whenSayHelloWorld() {
        String result = controller.index();
        Assert.assertEquals("hello world !",result);
    }
}
