package io.dustin.apps.user.domain.model;

import io.dustin.apps.common.code.YesOrNo;
import io.dustin.apps.common.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SiteUser extends BaseEntity {

    @Builder
    public SiteUser (Long id, @NotNull String nickName, @NotNull String password, @NotNull String email, YesOrNo isBaned) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.isBaned = isBaned == null ? YesOrNo.N : isBaned;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickName;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_baned", length = 1)
    private YesOrNo isBaned;

    private String password;

}
