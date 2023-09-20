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
public class UserRepository {

    private final RedissonClient redissonClient;

    public void save(User user) {
        /** db에 저장되었다고 가정합니다 */
        redissonClient.getBucket(user.getId(), StringCodec.INSTANCE).set(toJson(user));

    }

    public User findById(String id) {
        return convertObject(redissonClient.getBucket(id, StringCodec.INSTANCE).get().toString(), User.class);
    }




}
