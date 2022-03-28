package tech.das.springproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import tech.das.springproject.DTO.PlayerDTO;

import java.util.List;

@SpringBootTest
class SpringProjectApplicationTests {

     @Test
    void contextLoads() {
    }

    @Test
    @ValueSource
    void ffTest(){

         Assertions.assertEquals(10, 5 + 5);
    }



}
