package io.dustin.domain.user.model.entity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Builder
    public User(String id, String pwd, String email) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }

    private String id;

    private String pwd;

    private String email;

}
