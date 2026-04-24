package com.telusko.quizapp.model;

public class ApiResponse<T> {

    private T data;
    private String joke;

    public ApiResponse() {
    }

    public ApiResponse(T data, String joke) {
        this.data = data;
        this.joke = joke;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
