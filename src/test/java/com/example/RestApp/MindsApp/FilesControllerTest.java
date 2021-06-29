package com.example.RestApp.MindsApp;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FilesController.class})
@ExtendWith(SpringExtension.class)
public class FilesControllerTest {
    @MockBean
    private BusinessClass businessClass;

    @Autowired
    private FilesController filesController;

    @Test
    public void testConstructor() {


        // Arrange and Act
        new FilesController(new BusinessClass());
    }

    @Test
    public void testGetinfo() throws Exception {
        // Arrange
        when(this.businessClass.getinfo(anyString())).thenReturn(new ArrayList<String>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/information/{id}", "0178480");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(this.filesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

