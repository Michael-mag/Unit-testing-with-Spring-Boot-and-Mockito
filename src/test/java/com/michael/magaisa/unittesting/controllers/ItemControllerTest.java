package com.michael.magaisa.unittesting.controllers;

import com.michael.magaisa.unittesting.model.Item;
import com.michael.magaisa.unittesting.services.ItemBusinessServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessServiceImpl itemBusinessServiceImpl;

    @Test
    void dummyItemControllerTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"MacBook\",\"price\":1239}"
                )).andReturn();

    }

    @Test
    void ItemBusinessServiceTest() throws Exception {
        Mockito.when(itemBusinessServiceImpl.retrieveHardCodedItem())
                .thenReturn(new Item(1, "MacBook Pro 2020 M1 Chip", 1250, 11));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, name:\"MacBook Pro 2020 M1 Chip\", price:1250}"))
                .andReturn();
    }

    @Test
    void retrieveAllItemsFromDataBase() throws Exception {
        Mockito.when(itemBusinessServiceImpl.getAllItems()).thenReturn(
                Arrays.asList(
                        new Item(10002, "MacBook Pro M1 Chip", 1300, 7),
                        new Item(10003, "MacBook Air M1 Chip", 1250, 14)
                )
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

    MvcResult result =
        mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(
                content()
                    .json(
                        "[{id:10002, name:\"MacBook Pro M1 Chip\", price:1300}," +
                                "{id:10003, name:\"MacBook Air M1 Chip\", price:1250}]"))
            .andReturn();
    }
}
