package diego.spring.brewerymsvc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import diego.spring.brewerymsvc.web.model.BeerDTO;
import diego.spring.brewerymsvc.services.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    private BeerService beerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    BeerDTO validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Heineken")
                .beerStyle("Lager")
                .upc(123123123123L)
                .build();



    }

    @Test
    void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/"+ validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Heineken")));
    }

    @Test
    void handlePost() throws Exception {

        //Given
        BeerDTO beerDTO = validBeer;
        beerDTO.setId(null);
        BeerDTO saveDto = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.save(any(BeerDTO.class))).willReturn(saveDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testHandleUpdate() throws Exception {
        //given
        BeerDTO beerDTO = validBeer;
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        //when
        mockMvc.perform(put("/api/v1/beer/"+ validBeer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(UUID.class), any(BeerDTO.class));
    }
}