package io.rigo.sdk.common.client;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.account.model.Account;
import io.rigo.sdk.domain.account.service.NodeAccountService;
import io.rigo.sdk.domain.block.model.Block;
import io.rigo.sdk.domain.block.service.NodeBlockService;
import io.rigo.sdk.domain.transaction.model.Transaction;
import io.rigo.sdk.domain.transaction.service.NodeTransactionService;
import retrofit2.Call;

import static io.rigo.sdk.common.utils.CommonUtils.validPrefix;

/**
 * RigoWeb3 implement Object
 * created by basquiat
 */
public class RigoApiRestClientImpl implements RigoWeb3 {

    private final NodeAccountService nodeAccountService;
    private final NodeTransactionService nodeTransactionService;
    private final NodeBlockService nodeBlockService;

    public RigoApiRestClientImpl(String baseUrl) {
        nodeAccountService = RigoApiServiceGenerator.createService(NodeAccountService.class, baseUrl);
        nodeTransactionService = RigoApiServiceGenerator.createService(NodeTransactionService.class, baseUrl);
        nodeBlockService = RigoApiServiceGenerator.createService(NodeBlockService.class, baseUrl);
    }

    @Override
    public Account queryAccount(String address) {
        Call<NodeApiResponse<Account>> call = nodeAccountService.queryAccount(validPrefix(address));
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Transaction queryTrx(String txHash) {
        Call<NodeApiResponse<Transaction>> call = nodeTransactionService.queryTrx(validPrefix(txHash));
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Block queryBlockHeight(Integer height){
        Call<NodeApiResponse<Block>> call = nodeBlockService.queryBlockByHeight(height);
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Block queryBlockByHash(String hash){
        Call<NodeApiResponse<Block>> call = nodeBlockService.queryBlockByHash(validPrefix(hash));
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

}
