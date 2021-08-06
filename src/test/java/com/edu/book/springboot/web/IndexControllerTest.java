package com.edu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void mainPage_loading(){
        String body = this.restTemplate.getForObject("/", String.class);

        //실제로 Url 호출 시 페이지 내용이 제대로 호출되는 지 테스트
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }

}
