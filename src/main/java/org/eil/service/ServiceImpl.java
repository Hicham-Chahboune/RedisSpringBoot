package org.eil.service;

import org.eil.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements IService{

    @Autowired
    ICacheService<Response> cacheService;


    @Override
    @Cacheable(value = "book",key = "#id")
    public Long getThis(Long id) {
        return  id;
    }

    @Override
   // @Cacheable(value = "contract",key = "#numeroContratList[0]")
    public List<Response> getList(List<String> numeroContratList) {
        List<Response> responses = new ArrayList<>();
        List<String> nonExistId = new ArrayList<>();

        for(String id:numeroContratList){
            Response r = cacheService.get(id);
            if(r!=null) responses.add(r);
            else nonExistId.add(id);
        }

        for (String id:nonExistId){
            Response r = Response.builder().id(id).build();
            cacheService.put(id,r);
            responses.add(r);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return responses;
    }
}
