package org.eil.service.interfaces;

import org.eil.model.Response;

public interface ISerialisationService {
    String serialize(Response resource);

    Response deserialize(String serializedContract);
}
