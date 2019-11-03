package me.js.springboottest.sample.slicingTest;

import me.js.springboottest.sample.SampleController;
import me.js.springboottest.sample.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest(SampleController.class)
// --> WebMvcTest는 슬라이싱 테스트용이어서 웹과 관련된 것만 bean으로 등록됨
// 따라서 나머지 의존성은 다 끊킬 것이라 @Mockbean으로 생성해줘야함
// 컨트롤러 하나만 빈으로 등록하기 때문에 훨씬 가벼운 슬라이싱 테스트
public class WebMvcTest {
    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("jongseon");
        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hellojongseon"));
    }


}