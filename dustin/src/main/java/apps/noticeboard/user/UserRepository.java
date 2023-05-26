package apps.noticeboard.user;

import java.util.Optional;

import libs.entities.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long>{ // <>안에는 엔티티 클래스 이름과 ID 필드 타입이 지정된다.
    Optional<SiteUser> findByusername(String username); // 사용자 조회

}
