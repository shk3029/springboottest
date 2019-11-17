package me.js.springboottest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MvcController.class)
public class MvcControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hi() throws Exception {
        // 요청 "/hi"
        // 응답
        //  모델 name : jongseon
        //  뷰 이름 : hello
        mockMvc.perform(get("/hi"))
                .andExpect(status().isOk())
                .andDo(print()) // jsp의 경우는 불가능
                .andExpect(view().name("hi"))
                .andExpect(content().string(containsString("jongseon")))
                .andExpect(model().attribute("name",is("jongseon")));
    }
}