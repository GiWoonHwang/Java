package io.dustin.domain.user.repository;

import io.dustin.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

import static io.dustin.common.utils.CommonUtils.convertObject;
import static io.dustin.common.utils.CommonUtils.toJson;

@Repository
@RequiredArgsConstructor
public class CacheRepository {
    private final RedissonClient redissonClient;

    private final String PREFIX = "CACHED:";

    /** 발급된 토큰을 메모리에 올림 */
    public void cachedUser(String token, User user, Long expiredAt) {
        redissonClient.getBucket(PREFIX + token, StringCodec.INSTANCE).set(toJson(user), expiredAt, TimeUnit.SECONDS);
    }

    public User getCachedUser(String token) {
        return convertObject(redissonClient.getBucket(PREFIX + token, StringCodec.INSTANCE).get().toString(), User.class);
    }

}
