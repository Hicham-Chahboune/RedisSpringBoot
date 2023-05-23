package org.eil.service.interfaces;

import org.eil.model.Response;

import java.util.List;

public interface IService {
    Long getThis(Long id);

    List<Response> getList(List<String> collect);

    void update(String id);
}
