package org.eil.service;

import com.google.gson.Gson;
import org.eil.model.Response;
import org.eil.service.interfaces.ICacheService;
import org.eil.service.interfaces.ISerialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


@Service
public class CacheServiceImpl implements ICacheService<Response> {

    private String prefix = "contrat:";
    private Jedis jedis ;

    private RedisConnectionFactory redisConnectionFactory;

    public CacheServiceImpl(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
         jedis = (Jedis) redisConnectionFactory.getConnection().getNativeConnection();
    }

    @Autowired
    private ISerialisationService serialisationService;


    @Override
    public Response get(String key) {
        return serialisationService.deserialize(jedis.get(prefix+key));
    }

    @Override
    public void put(String key, Response resource) {
        jedis.set(prefix+key,serialisationService.serialize(resource));
    }

    @Override
    public void delete(String key){
        jedis.del(prefix+key);
    }


}
