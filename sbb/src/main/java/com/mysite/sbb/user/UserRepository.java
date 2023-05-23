package com.mysite.sbb.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long>{ // <>안에는 엔티티 클래스 이름과 ID 필드 타입이 지정된다.
}
