package com.redis.transaction.service;

import com.redis.log.Loggers;
import com.redis.transaction.service.cluster.JedisClusterFactory;
import com.redis.util.TimeUtil;
import org.slf4j.Logger;

import java.util.Date;

/**
 * Created by jiangwenping on 17/3/21.
 * redis集群服务
 */
public class RedisClusterService implements IRedisService{

    protected static Logger logger = Loggers.redisLogger;

    private JedisClusterFactory jedisClusterFactory;

    @Override
    public void expire(String key, int seconds) {
        try {
            jedisClusterFactory.getObject().expire(key, seconds);
        } catch (Exception e) {
            logger.error(TimeUtil.getDateString(new Date()) + ":::::" + "expire" + key, e);
        }
    }

    @Override
    public boolean deleteKey(String key) {
        return false;
    }

    @Override
    public boolean setNxString(String key, String value, int seconds) throws Exception {
        return false;
    }

    @Override
    public boolean setHnxString(String key, String field, String value) throws Exception {
        return false;
    }

    @Override
    public void setString(String key, String object) {

    }

    @Override
    public void setString(String key, String value, int seconds) {

    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public String getString(String key, int seconds) {
        return null;
    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    public JedisClusterFactory getJedisClusterFactory() {
        return jedisClusterFactory;
    }

    public void setJedisClusterFactory(JedisClusterFactory jedisClusterFactory) {
        this.jedisClusterFactory = jedisClusterFactory;
    }
}
