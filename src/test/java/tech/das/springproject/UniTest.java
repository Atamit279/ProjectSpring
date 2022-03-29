package tech.das.springproject;


import com.jayway.jsonpath.internal.function.text.Length;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.das.springproject.DTO.PlayerDTO;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UniTest {

    @DisplayName("Test for not Null name")
    @Test
    void  notNullName() {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Atamit");
        playerDTO.setLvl(11L);



        assertNotNull(playerDTO.getName());


    }

    @DisplayName("Test: Player lvl < 10")
    @Test
    void PlayerLvl() {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Atamit");
        playerDTO.setLvl(1L);

        boolean x = false;
        if (playerDTO.getLvl() < 10){
            x = true;
        }

        assertTrue(x);
    }

    @DisplayName("Test: Player name check length < 10")
    @Test
    void NameLength(){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Atamit");


        String lng = playerDTO.getName();
        int len1 = lng.length();
        boolean x = false;
        if (len1 < 10){
            x = true;
        }

        assertTrue(x);
    }



}
