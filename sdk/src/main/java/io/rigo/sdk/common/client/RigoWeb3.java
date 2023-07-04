package io.rigo.sdk.common.client;

import io.rigo.sdk.domain.account.model.Account;
import io.rigo.sdk.domain.block.model.Block;
import io.rigo.sdk.domain.delegatee.model.Delegatee;
import io.rigo.sdk.domain.rule.model.Rule;
import io.rigo.sdk.domain.stake.model.Stake;
import io.rigo.sdk.domain.transaction.model.Transaction;
import io.rigo.sdk.domain.validator.model.Validator;
import io.rigo.sdk.subscriber.Subscriber;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;

/**
 * RigoWeb3 Interface
 * created by basquiat
 */
public interface RigoWeb3 {

    Account queryAccount(String address);

    Validator queryValidators(long height);

    Stake queryStakes(String address);

    Delegatee queryDelegatee(String address);

    Transaction queryTrx(String txHash);

    Block queryBlockHeight(Integer height);
    Block queryBlockByHash(String hash);

    Rule queryRule();

    Subscriber subscribe(String websocketUrl, DefaultEventType eventType, String subQuery, SubscriberCallback callback);
}
