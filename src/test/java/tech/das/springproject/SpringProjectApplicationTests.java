package tech.das.springproject;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.reactive.function.BodyInserters;
import tech.das.springproject.DTO.PlayerDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "PT1M")//30 seconds
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SpringProjectApplicationTests {

     @Test
    void contextLoads() {
    }

    @Test
    @ValueSource
    void ffTest(){

         Assertions.assertEquals(10, 5 + 5);
    }

    private String serverURL;

    @LocalServerPort
    private int port;

    private final WebTestClient webTestClient;

    @Mock
    private HttpServletRequest request;

    @BeforeAll
    public void setUp(){
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        serverURL = String.format("%s:%s", "localhost", port);

    }

    @Test
    void saveValidUniversity(){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Atamit");
        playerDTO.setLvl(1L);

        //act
        PlayerDTO savedPlayer = this.webTestClient
                .post()
                .uri(serverURL + "/api/service/player/save")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(playerDTO))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(PlayerDTO.class)
                .returnResult()
                .getResponseBody();


        assertNotNull(savedPlayer);
//		Assertions.assertEquals(universityDTO.getId(), savedUniversity.getId());
//		Assertions.assertEquals(universityDTO.getName(), savedUniversity.getName());
//		Assertions.assertEquals(universityDTO.getId(), savedUniversity.getId());
////		Assertions.assertEquals(universityDTO, res);

        HttpStatus deleteUni = this.webTestClient
                .delete()
                .uri(serverURL + "/api/service/player/deleteById/" + savedPlayer.getId())
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(HttpStatus.class)
                .returnResult()
                .getResponseBody();
    }

    @Test
    void getRequest(){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName("Atamit");
        playerDTO.setLvl(1L);
        Long id = 1L;

        PlayerDTO savedPlayer = this.webTestClient
                .post()
                .uri(serverURL + "/api/service/player/save")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(playerDTO))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(PlayerDTO.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(savedPlayer);

        //act
        PlayerDTO getUni = this.webTestClient
                .get()
                .uri(serverURL + "/api/service/player/getById/" + savedPlayer.getId())
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(PlayerDTO.class)
                .returnResult()
                .getResponseBody();

        HttpStatus deleteUni = this.webTestClient
                .delete()
                .uri(serverURL + "/api/service/player/deleteById/" + savedPlayer.getId())
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(HttpStatus.class)
                .returnResult()
                .getResponseBody();


        assertNotNull(getUni);
        Assertions.assertEquals(savedPlayer.getId(), getUni.getId());
        Assertions.assertEquals(savedPlayer.getName(), getUni.getName());
     //   Assertions.assertEquals(playerDTO.getId(), getUni.getId());
//		Assertions.assertEquals(universityDTO, res);
    }

    @Test
    void deleterRequest(){


       PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(1L);
        playerDTO.setName("Atamit");
        playerDTO.setLvl(1L);

        PlayerDTO savedPlayer = this.webTestClient
                .post()
                .uri(serverURL + "/api/service/player/save")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(playerDTO))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(PlayerDTO.class)
                .returnResult()
                .getResponseBody();


        //act
        HttpStatus deleteUni = this.webTestClient
                .delete()
                .uri(serverURL + "/api/service/player/deleteById/" + savedPlayer.getId())
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(HttpStatus.class)
                .returnResult()
                .getResponseBody();


        assertNotNull(savedPlayer);
    }


    private static List<PlayerDTO> getValidUniversity(){

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(1L);
        playerDTO.setName("Atamit");
        playerDTO.setLvl(1L);

        PlayerDTO playerDTO1 = new PlayerDTO();
        playerDTO1.setId(2L);
        playerDTO1.setName("Atamit");
        playerDTO1.setLvl(1L);

        PlayerDTO playerDTO2 = new PlayerDTO();
        playerDTO2.setId(3L);
        playerDTO2.setName("Atamit");
        playerDTO2.setLvl(1L);

        PlayerDTO playerDTO3 = new PlayerDTO();
        playerDTO3.setId(4L);
        playerDTO3.setName("Atamit");
        playerDTO3.setLvl(1L);

        List<PlayerDTO> playerDTOList = new ArrayList<>();
       playerDTOList.add(playerDTO);
        playerDTOList.add(playerDTO1);
        playerDTOList.add(playerDTO2);
        playerDTOList.add(playerDTO3);

        return playerDTOList;
    }

}
