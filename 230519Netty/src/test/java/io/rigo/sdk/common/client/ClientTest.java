package io.rigo.sdk.common.client;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.block.model.Block;
import io.rigo.sdk.domain.block.service.NodeBlockService;
import io.rigo.sdk.domain.transaction.model.Transaction;
import io.rigo.sdk.domain.transaction.service.NodeTransactionService;
import retrofit2.Call;

public class ClientTest {

    public static void main(String[] args) {
        String baseUrl = "http://192.168.252.60:26657";
//        NodeAccountService account = RigoApiServiceGenerator.createService(NodeAccountService.class, baseUrl);
//        Call<NodeApiResponse<Account>> callAccount = account.queryAccount("0xDF976A96545DAD0E0B14FED615587A89BA980B84");
//        NodeApiResponse<Account> responseAccount = RigoApiServiceGenerator.executeSync(callAccount);
//        System.out.println(responseAccount.getResult().toString());


//        NodeTransactionService trx = RigoApiServiceGenerator.createService(NodeTransactionService.class, baseUrl);
//        Call<NodeApiResponse<Transaction>> callTrx = trx.queryTrx("0xed4ecb8368bd3d37b63374ab015d7e947eb2354b44810b392172a59bd5561a21");
//        NodeApiResponse<Transaction> responseTrx = RigoApiServiceGenerator.executeSync(callTrx);
//        System.out.println(responseTrx.getResult().toString());


//        NodeBlockService block = RigoApiServiceGenerator.createService(NodeBlockService.class, baseUrl);
//        Call<NodeApiResponse<BlockResult>> callBlock = block.queryBlockByHeight(1);
//        NodeApiResponse<BlockResult> responseBlock = RigoApiServiceGenerator.executeSync(callBlock);
//        System.out.println(responseBlock.getResult().toString());

        NodeBlockService block = RigoApiServiceGenerator.createService(NodeBlockService.class, baseUrl);
        Call<NodeApiResponse<Block>> callBlock = block.queryBlockByHash("0x642BA1CB19223A9B4B2FDA4966A0A35ABE7A0B609136B4711CC52757AD309A8C");
        NodeApiResponse<Block> responseBlock = RigoApiServiceGenerator.executeSync(callBlock);
        System.out.println(responseBlock.getResult().toString());
        NodeTransactionService trx = RigoApiServiceGenerator.createService(NodeTransactionService.class, baseUrl);
        Call<NodeApiResponse<Transaction>> callTrx = trx.queryTrx("0xc9733e7319859c50794fbe15b26efc6f59efad1941f5167da5a2c0c1cab056a2");
        NodeApiResponse<Transaction> responseTrx = RigoApiServiceGenerator.executeSync(callTrx);
        System.out.println(responseTrx.getResult().toString());
    }
}
