package com.practice.utesting.unittesting.unitTestsWithSpring.testingControllers;

import com.practice.utesting.unittesting.controllers.BasicController;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * On testing a no dependency controller, simple calls to controller's endpoints is simple using 'MockMvc'.
 */
@WebMvcTest(BasicController.class)
public class BasicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSimpleMessage() throws Exception {

        RequestBuilder  req = MockMvcRequestBuilders
                .get("/getSimpleMessage")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult res = mockMvc
                .perform(req)
                .andExpect(status().isOk()) // quickly pre-check response status
                .andReturn();

        // verifying req . res
        String expectedRes = "Hello";
        String actualRes = res.getResponse().getContentAsString();
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void testGetSimpleJsonMessage() throws Exception {

        RequestBuilder  req = MockMvcRequestBuilders
                .get("/getSimpleJsonMessage")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult res = mockMvc
                .perform(req)
                .andExpect(status().isOk()) // quickly pre-check response status
                .andReturn();

        String expectedRes = "{id:1, name:laptop, price:1000, quantity:100}";
        String actualRes = res.getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedRes, actualRes, false); // Enable strict mode for strict verification on each json property
    }
}
