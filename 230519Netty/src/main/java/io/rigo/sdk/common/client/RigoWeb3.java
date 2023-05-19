package io.rigo.sdk.common.client;

import io.rigo.sdk.domain.account.model.Account;
import io.rigo.sdk.domain.block.model.Block;
import io.rigo.sdk.domain.transaction.model.Transaction;

/**
 * RigoWeb3 Interface
 * created by basquiat
 */
public interface RigoWeb3 {
    Account queryAccount(String address);
    Transaction queryTrx(String txHash);
    Block queryBlockHeight(Integer height);
    Block queryBlockByHash(String hash);
}
