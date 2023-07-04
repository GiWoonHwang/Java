package io.rigo.sdk.common.client;

import io.rigo.sdk.common.client.model.NodeApiResponse;
import io.rigo.sdk.domain.account.model.Account;
import io.rigo.sdk.domain.account.service.NodeAccountService;
import io.rigo.sdk.domain.block.model.Block;
import io.rigo.sdk.domain.block.service.NodeBlockService;
import io.rigo.sdk.domain.delegatee.model.Delegatee;
import io.rigo.sdk.domain.delegatee.service.NodeDelegateeService;
import io.rigo.sdk.domain.rule.model.Rule;
import io.rigo.sdk.domain.rule.service.NodeRuleService;
import io.rigo.sdk.domain.stake.model.Stake;
import io.rigo.sdk.domain.stake.service.NodeStakeService;
import io.rigo.sdk.domain.transaction.model.Transaction;
import io.rigo.sdk.domain.transaction.service.NodeTransactionService;
import io.rigo.sdk.domain.validator.model.Validator;
import io.rigo.sdk.domain.validator.service.NodeValidatorService;
import io.rigo.sdk.subscriber.Subscriber;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;

import static io.rigo.sdk.common.utils.CommonUtils.validPrefix;

/**
 * RigoWeb3 implement Object
 * created by basquiat
 */
@Slf4j
public class RigoApiRestClientImpl implements RigoWeb3 {

    private final NodeAccountService nodeAccountService;
    private final NodeTransactionService nodeTransactionService;
    private final NodeBlockService nodeBlockService;
    private final NodeValidatorService nodeValidatorService;
    private final NodeStakeService nodeStakeService;
    private final NodeDelegateeService nodeDelegateeService;
    private final NodeRuleService nodeRuleService;

    public RigoApiRestClientImpl(String baseUrl) {
        nodeAccountService = RigoApiServiceGenerator.createService(NodeAccountService.class, baseUrl);
        nodeTransactionService = RigoApiServiceGenerator.createService(NodeTransactionService.class, baseUrl);
        nodeBlockService = RigoApiServiceGenerator.createService(NodeBlockService.class, baseUrl);
        nodeValidatorService = RigoApiServiceGenerator.createService(NodeValidatorService.class, baseUrl);
        nodeStakeService = RigoApiServiceGenerator.createService(NodeStakeService.class, baseUrl);
        nodeRuleService = RigoApiServiceGenerator.createService(NodeRuleService.class, baseUrl);
        nodeDelegateeService = RigoApiServiceGenerator.createService(NodeDelegateeService.class, baseUrl);
    }

    @Override
    public Account queryAccount(String address) {
        Call<NodeApiResponse<Account>> call = nodeAccountService.queryAccount(validPrefix(address));
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Validator queryValidators(long height) {
        Call<NodeApiResponse<Validator>> call = nodeValidatorService.queryValidators(height);
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Stake queryStakes(String address) {
        Call<NodeApiResponse<Stake>> call = nodeStakeService.queryStakes(validPrefix(address));
        return RigoApiServiceGenerator.executeSync(call).getResult();
    }

    @Override
    public Delegatee queryDelegatee(String address) {
        Call<NodeApiResponse<Delegatee>> call = nodeDelegateeService.queryDelegatee(validPrefix(address));
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

    @Override
    public Rule queryRule(){
        Call<NodeApiResponse<Rule>> call = nodeRuleService.queryRule();
        return RigoApiServiceGenerator.executeSync(call).getResult();

    }

    @Override
    public Subscriber subscribe(String websocketUrl, DefaultEventType eventType, String subQuery, SubscriberCallback callback) {
        Subscriber subscriber = new Subscriber(websocketUrl);
        try {
            subscriber.start(eventType, subQuery, callback);
        } catch (InterruptedException e) {
            log.info("interrupt error message : " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return subscriber;
    }

}
