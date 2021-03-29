package com.hajin.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//JUnit - java에서 테스트 코드 작성을 도와주는 프레임워크

@RunWith(SpringRunner.class)//JUnit에 내장된 실행자 외에 다른 실행자(SpringRunner) 실행시킴 -> 스프링부트 테스트와 JUnit 연결
@WebMvcTest
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; //웹 api 테스트할 때 사용, 스프링 mvc 테스트의 시작

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk())//결과 검증(status 검증)
                .andExpect(content().string(hello));//(본문의 내용 검증)
    }
}
