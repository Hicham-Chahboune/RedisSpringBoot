package org.eil.service;

public interface ICacheService <T>{
     T get(String key);
     void put(String key,T resource);
     String serialize(T resource);
     T deserialize(String serializedContract);
}
