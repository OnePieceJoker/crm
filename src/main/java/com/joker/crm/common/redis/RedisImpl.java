package com.joker.crm.common.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

@Service
public class RedisImpl implements Redis {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private String appendKeyPrefix(Object key) {
        if (key instanceof String) {
            return ((String) key);
        }
        return key.toString();
    }

    @Override
    public void del(Object... keys) {
        List<String> keysList = new ArrayList<>();
        for (Object key : keysList) {
            keysList.add(appendKeyPrefix(key));
        }
        redisTemplate.delete(keysList);
    }

    @Override
    public Long ttl(String key) {
        return redisTemplate.getExpire(appendKeyPrefix(key));
    }

    @Override
    public void expire(String key, Integer timeout) {
        redisTemplate.expire(appendKeyPrefix(key), timeout, TimeUnit.SECONDS);
    }

    @Override
    public void persist(String key) {
        redisTemplate.persist(appendKeyPrefix(key));
    }

    @Override
    public boolean exists(String key) {
        Boolean exists = redisTemplate.hasKey(appendKeyPrefix(key));
        return exists != null ? exists : false;
    }

    @Override
    public DataType getType(String key) {
        return redisTemplate.type(appendKeyPrefix(key));
    }

    // redis strings

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(appendKeyPrefix(key), value);
    }

    @Override
    public void setex(Object key, Integer second, Object value) {
        redisTemplate.opsForValue().set(appendKeyPrefix(key), value, second, TimeUnit.SECONDS);
    }

    @Override
    public Boolean setNx(String key, Long timeout, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(appendKeyPrefix(key), value, timeout, TimeUnit.SECONDS);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(appendKeyPrefix(key));
    }

    @Override
    public List<Object> mGet(Object... keys) {
        List<String> keysList = new ArrayList<>();
        for (Object key : keys) {
            keysList.add(appendKeyPrefix(key));
        }
        return redisTemplate.opsForValue().multiGet(keysList);
    }

    @Override
    public void mSet(Map<String, Object> map) {
        for (String key : map.keySet()) {
            Object value = map.remove(key);
            map.put(appendKeyPrefix(key), value);
        }
        redisTemplate.opsForValue().multiSet(map);
    }

    @Override
    public void mSetNx(Map<String, Object> map) {
        for (String key : map.keySet()) {
            Object value = map.remove(key);
            map.put(appendKeyPrefix(key), value);
        }
        redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    @Override
    public void appendStr(Object key, String value) {
       redisTemplate.opsForValue().append(appendKeyPrefix(key), value); 
    }

    // redis hashs

    @Override
    public void hdel(Object key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(appendKeyPrefix(key), hashKeys);
    }

    @Override
    public void put(Object key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(appendKeyPrefix(key), hashKey, value);
    }

    @Override
    public void putAll(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(appendKeyPrefix(key), map);
    }

    @Override
    public Map<Object, Object> getRedisMap(String key) {
        return redisTemplate.opsForHash().entries(appendKeyPrefix(key));
    }

    @Override
    public List<Object> getValues(Object key) {
        return redisTemplate.opsForHash().values(appendKeyPrefix(key));
    }

    @Override
    public Boolean hashMapKey(Object key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(appendKeyPrefix(key), hashKey);
    }

    // redis list

    @Override
    public void lpush(String key, Object value) {
        redisTemplate.opsForList().leftPush(appendKeyPrefix(key), value);
    }

    @Override
    public void rpush(String key, Object value) {
        redisTemplate.opsForList().rightPush(appendKeyPrefix(key), value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T lPop(String key) {
        return (T) redisTemplate.opsForList().leftPop(appendKeyPrefix(key));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T rPop(String key) {
        return (T) redisTemplate.opsForList().rightPop(appendKeyPrefix(key));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getKeyIndex(String key, int index) {
        return (T) redisTemplate.opsForList().index(appendKeyPrefix(key), index);
    }

    @Override
    public Long getLength(String key) {
        return redisTemplate.opsForList().size(appendKeyPrefix(key));
    }

    @Override
    public List<Object> range(String key, int start, int end) {
        return redisTemplate.opsForList().range(appendKeyPrefix(key), start, end);
    }

    // set操作
    @Override
    public void addSet(String key, Object... values) {
        redisTemplate.opsForSet().add(appendKeyPrefix(key), values);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getSet(String key) {
        return (T) redisTemplate.opsForSet().pop(appendKeyPrefix(key));
    }

    @Override
    public Set<Object> getSets(String key) {
        return redisTemplate.opsForSet().members(appendKeyPrefix(key));
    }

    @Override
    public Long getSetsNum(String key) {
        return redisTemplate.opsForSet().size(appendKeyPrefix(key));
    }

    @Override
    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(appendKeyPrefix(key));
    }

    // zSet操作

    /**
     * 添加数据
     * <p>
     * 添加方式：
     * 1.创建一个set集合
     * Set<ZSetOperations.TypedTuple<Object>> sets=new HashSet<>();
     * 2.创建一个有序集合
     * ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>(value,排序的数值，越小越在前);
     * 4.放入set集合
     * sets.add(objectTypedTuple1);
     * 5.放入缓存
     * reidsImpl.Zadd("zSet", list);
     *
     * @param key    key
     * @param tuples tuples
     */
    @Override
    public void zadd(String key, Set<TypedTuple<Object>> tuples) {
        redisTemplate.opsForZSet().add(appendKeyPrefix(key), tuples);
    }

    @Override
    public Set<Object> reverseRange(String key, Double min, Double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(appendKeyPrefix(key), min, max);
    }
    
}
