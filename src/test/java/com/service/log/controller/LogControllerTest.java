package com.service.log.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogController.class)
class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLogRequestValidNumberList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[1,2,3]"))
                .andExpect(status().isOk());
    }

    @Test
    void testLogRequestInvalidNumberList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[]"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testLogRequestInvalidBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void testLogRequestWithoutBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/log")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }
}
