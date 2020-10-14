package com.lundegaard.demo.services;

import com.lundegaard.demo.entities.RequestKind;
import com.lundegaard.demo.repositories.RequestKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RequestKindService {

    private final RequestKindRepository requestKindRepository;

    @Autowired
    public RequestKindService(RequestKindRepository requestKindRepository) {
        this.requestKindRepository = requestKindRepository;
    }

    @Cacheable("requestKind")
    public Iterable<RequestKind> getRequestKindList() {
        return requestKindRepository.findAll();
    }
}
