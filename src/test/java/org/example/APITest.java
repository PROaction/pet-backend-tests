package org.example;

import com.google.gson.Gson;
//import feign.Feign;
//import feign.gson.GsonDecoder;
//import feign.gson.GsonEncoder;
//import feign.jaxrs.JAXRSContract;
import org.example.api_client.APIClient;
import org.example.requests_models.DeleteuserRequest;
import org.example.requests_models.DoregisterRequest;
import org.example.response_models.DoregisterResponse;
import org.example.response_models.ResponseWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class APITest {
    private APIClient apiClient;
    private Gson gson;

    @Before
    public void setup() {
        this.apiClient = new APIClient();
        this.gson = new Gson();
    }

    @Test
    public void testUserRegister() throws IOException {
        DoregisterRequest request = DoregisterRequest.builder()
                .email("sergey@mail.ru")
                .name("Sergey")
                .password("123")
                .build();

        ResponseWrapper<DoregisterResponse> responseWrapper = apiClient.sendRequest(
                "http://users.bugred.ru/tasks/rest/doregister",
                request,
                DoregisterResponse.class
        );

        System.out.println("Status Code: " + responseWrapper.getStatusCode());
        System.out.println("Response Body: " + gson.toJson(responseWrapper.getResponse()));

        Assert.assertEquals(200, responseWrapper.getStatusCode());
        Assert.assertEquals(request.getName(), responseWrapper.getResponse().getName());
    }

    @After
    public void tearDown() throws IOException {
        DeleteuserRequest request = DeleteuserRequest.builder()
                .email("sergey@mail.ru")
                .build();

        apiClient.sendRawRequest(
                "http://users.bugred.ru/tasks/rest/deleteuser",
                request
        );
    }
}
