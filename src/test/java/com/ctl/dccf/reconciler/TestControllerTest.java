package com.ctl.dccf.reconciler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Pramod on 1/8/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {
    @Inject
    private MockMvc mvc;

    @Test
    public void testGetUser() throws Exception{
        mvc.perform(get("/test/users")
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", "59f8e17224aa9a0001818a06"))
                .andExpect(status().isOk())
                .andDo(print());
        //{"ssoUserName":"test123","linkedUsers":[{"idp":"idp1","name":"idp1name"},{"idp":"idp2","name":"idp2name"},{"idp":"idp3","name":"idp3name"}],"status":"Complete","lastSync":{"startDate":"2017-11-02T21:24:02Z","endDate":"2017-11-02T21:24:02Z","duration":0},"containers":["59ee4a55a7f2a115687a2f36","59ef4146d5c491fbcb92348f"]}
    }


}
