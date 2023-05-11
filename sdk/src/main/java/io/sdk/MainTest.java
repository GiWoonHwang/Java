package io.sdk;

import io.sdk.common.Client;
import retrofit2.Call;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        Call<Object> Blocks = Client.getBlockService().getBlockByHeight(131);
        try {
            System.out.println(Blocks.execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
