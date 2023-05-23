package org.eil.service;

import org.eil.model.Response;

import java.util.List;

public interface IService {
    Long getThis(Long id);

    List<Response> getList(List<String> collect);
}
