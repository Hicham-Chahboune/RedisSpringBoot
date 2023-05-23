package org.eil.service.interfaces;

public interface ICacheService <T>{
     T get(String key);
     void put(String key,T resource);

     void delete(String key);

   
}
