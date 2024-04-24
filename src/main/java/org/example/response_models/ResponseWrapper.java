package org.example.response_models;

public class ResponseWrapper<T> {
    private int statusCode;
    private T response;

    public ResponseWrapper(int statusCode, T response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getResponse() {
        return response;
    }
}
