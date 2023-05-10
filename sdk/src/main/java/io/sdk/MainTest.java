package io.sdk;

import retrofit2.Call;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        Call<Object> getTest = RetrofitClient.getApiService().getTest();
        try {
            System.out.println(getTest.execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
