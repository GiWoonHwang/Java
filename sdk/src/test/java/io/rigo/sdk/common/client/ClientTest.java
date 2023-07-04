package io.rigo.sdk.common.client;

import io.rigo.sdk.common.client.factory.RigoApiClientFactory;

public class ClientTest {

    public static void main(String[] args) {
        String baseUrl = "http://192.168.252.60:26657";

        RigoApiClientFactory factory = RigoApiClientFactory.newInstance(baseUrl);
        RigoWeb3 rigoWeb3 = factory.rigoWeb3();
        System.out.println(rigoWeb3.queryAccount("DF976A96545DAD0E0B14FED615587A89BA980B84"));
        System.out.println(rigoWeb3.queryTrx("a33f9da56f41fdcbce2814927b22c17ec10119deb380452048db76b6d70ad747"));
        System.out.println(rigoWeb3.queryBlockHeight(1));
        System.out.println(rigoWeb3.queryBlockByHash("3529E5B15C7295C21E1F039880F0D7BB4BA41AED33FD214FCB6FAA047CAC01F7"));
        System.out.println(rigoWeb3.queryValidators(11));
        System.out.println(rigoWeb3.queryRule());
        System.out.println(rigoWeb3.queryStakes("52daee02899a17d4f3abdf5aedc3c7a5e69a0d3c"));
        System.out.println(rigoWeb3.queryDelegatee("0x54edc49c169113c505cb4dba532ef71fad6190c9"));


    }
}
