package io.dustin.apps.user.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SiteUser {

    @Builder
    public SiteUser(Long id, @NotNull String nickName, @NotNull String password, @NotNull String email) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickName;

    private String password;

    @Column(unique = true)
    private String email;

}
