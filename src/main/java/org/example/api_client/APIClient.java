package org.example.api_client;

import com.google.gson.Gson;

//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Request;
//import javax.ws.rs.core.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

import org.example.response_models.ResponseWrapper;

import java.io.IOException;

public class APIClient {
    private OkHttpClient client;
    private Gson gson;

    public APIClient() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public <T> ResponseWrapper<T> sendRequest(String url, Object request, Class<T> responseClass) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                gson.toJson(request)
        );

        Request httpRequest = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            T parsedResponse = gson.fromJson(response.body().string(), responseClass);
            return new ResponseWrapper<>(response.code(), parsedResponse);
        }
    }

    public Response sendRawRequest(String url, Object request) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                gson.toJson(request)
        );

        Request httpRequest = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        return client.newCall(httpRequest).execute();
    }
}


//public interface APIClient {
//    @POST
//    @Path("/doregister")
//    DoregisterResponse doRegister(DoregisterRequest request);
//
//    @POST
//    @Path("/deleteuser")
//    DeleteuserResponse deleteUser(DeleteuserRequest request);
//}
