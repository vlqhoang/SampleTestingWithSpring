package com.practice.utesting.unittesting.unitTestsWithSpring.testingControllers;

import com.practice.utesting.unittesting.controllers.ItemController;
import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.services.BasicBusinessService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Some controllers will have their dependencies (services, ..) , mocking of those dependencies is required.
 * Otherwise, tests cannot be executed.
 */
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @SpyBean
    @MockBean
    private BasicBusinessService businessService; // provide dependency of this controller

    @Test
    public void testDataFromService() throws Exception {

        // ** When is not required if using @SpyBean **
        when(businessService.getHardcodedData())
                .thenReturn(new Item(1, "laptop", 1000, 100));

        RequestBuilder req = MockMvcRequestBuilders
                .get("/getHardcodedItem")
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
