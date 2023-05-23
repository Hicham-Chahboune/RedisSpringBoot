package org.eil.service;

import com.google.gson.Gson;
import org.eil.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class CacheServiceImpl implements ICacheService<Response>{

    private Gson gson = new Gson();
    private String prefix = "contrat:";
    private Jedis jedis ;
    private RedisConnectionFactory redisConnectionFactory;

    public CacheServiceImpl(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
         jedis = (Jedis) redisConnectionFactory.getConnection().getNativeConnection();
    }


    @Override
    public Response get(String key) {
        return deserialize(jedis.get(prefix+key));
    }

    @Override
    public void put(String key, Response resource) {
        jedis.set(prefix+key,serialize(resource));
    }

    @Override
    public String serialize(Response resource) {
        return gson.toJson(resource);
    }

    @Override
    public Response deserialize(String serializedContract) {
        return gson.fromJson(serializedContract,Response.class);
    }

}
