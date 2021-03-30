package com.hajin.springboot.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name); //테스트 검증 라이브러리의 검증 메소드, 검증받고 싶은 대상을 메소드 인자로
        //junit asserThat assertThat(dto.getName(),is(name)) -> CoreMatchers 라이브러리 필요
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
