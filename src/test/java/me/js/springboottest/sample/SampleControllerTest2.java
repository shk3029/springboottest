package me.js.springboottest.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// webEnviorment - RANDOM_PORT, DEFINED_PROT
// Synchronous TestRestTemplate 사용
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/*
    * webEnviorment - RANDOM_PORT, DEFINED_PROT
        실제로 서블릿 컨테이너(내장톰켓)가 뜸
        따라서 이땐 mockMvc를 쓰는게 아니라, REST template이나 테스트용 웹 클라이언트를 써야함
 */
public class SampleControllerTest2 {
    // synchronous
    @Autowired
    TestRestTemplate testRestTemplate;

    // if, 컨트롤만 테스트하고 싶다? 서비스는 목킹
    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("jongseon");
        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("hellojongseon");
    }
}