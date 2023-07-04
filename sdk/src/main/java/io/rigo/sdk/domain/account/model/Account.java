package io.rigo.sdk.domain.account.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Rigo Account
 */
@Getter
@ToString
@NoArgsConstructor
public class Account {
    private String key;
    private AccountInfo value;
}
