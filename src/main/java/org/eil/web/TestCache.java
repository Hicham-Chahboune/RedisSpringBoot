package org.eil.web;

import lombok.AllArgsConstructor;
import org.eil.model.Request;
import org.eil.model.Response;
import org.eil.service.interfaces.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestCache {

    private IService service;

    @GetMapping("{id}")
    public Long getThis(@PathVariable Long id){
        return service.getThis(id);
    }

    @GetMapping()
    public List<Response> getThis(@RequestBody List<Request> requests){
        return service.getList(requests.stream().map(e->e.getId()).collect(Collectors.toList()));
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id){
        service.update(id);
    }



}
