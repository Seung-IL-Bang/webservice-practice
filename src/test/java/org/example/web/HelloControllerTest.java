package org.example.web;

import org.example.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}


// @RunWith(SpringRunner.class)
// 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킨다.
// 여기서는 SpringRunner 라는 스프링 실행자를 사용한다.
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.

// @WebMvcTest(controllers = HelloController.class)
// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
// 단, @Service, @Component, @Repository 등은 사용할 수 없다.
// 여기서는 컨트롤러만 사용하기 때문에 선언한다.

// @Autowired
// 스프링이 관리하는 빈(Bean)을 주입 받는다.

// private MockMvc mvc;
// 웹 API 를 테스트할 때 사용한다.
// 스프링 MVC 테스트의 시작점이다.
// 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

// mvc.perform(get("/hello"))
// MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 한다.
// 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.

// .andExpect(status().isOk())
// mvc.perform 의 결과를 검증한다.
// HTTP Header 의 Status 를 검증한다.
// OK 즉 200인지 아닌지 검증한다.

// .andExpect(content().string(hello));
// 응답 본문의 내용을 검증한다.
// Controller 에서 "hello" 를 리턴하는지 검증한다.

// param
// API 테스트할 때 사용될 요청 파라미터를 설정한다.
// 단, 값은 String 만 허용된다.
// 그래서 숫자/날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능하다.

// jsonPath
// JSON 응답값을 필드별로 검증할 수 있는 메소드이다.
// $ 를 기준으로 필드명을 명시한다.
// 여기서는 name 과 amount 를 검증하니 $.name, $.amount 로 검증한다.

