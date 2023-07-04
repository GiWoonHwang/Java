package io.rigo.sdk.domain.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AccountInfo {
    private String address;
    private String nonce;
    private String balance;
}
