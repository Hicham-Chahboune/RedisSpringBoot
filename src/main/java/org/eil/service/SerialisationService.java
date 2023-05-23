package org.eil.service;

import com.google.gson.Gson;
import org.eil.model.Response;
import org.eil.service.interfaces.ISerialisationService;
import org.springframework.stereotype.Service;

@Service
public class SerialisationService implements ISerialisationService {

    private Gson gson = new Gson();


    @Override
    public String serialize(Response resource) {
        return gson.toJson(resource);
    }

    @Override
    public Response deserialize(String serializedContract) {
        return gson.fromJson(serializedContract,Response.class);
    }


}
