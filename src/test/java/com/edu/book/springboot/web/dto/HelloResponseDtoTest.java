package com.edu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //assertj : 테스트 검증 라이브러리 (Junit 대체)
        //assertThat : 검증 라이브러리의 메소드. 검증하고 싶은 대상을 메소드 인자로 받음
        //isEqualTo : 동등 비교 메소드. 값이 같을 때만 성공.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
