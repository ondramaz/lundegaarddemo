package com.lundegaard.demo.services;

import com.lundegaard.demo.entities.Request;
import com.lundegaard.demo.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Iterable<Request> getRequestList() {
        return requestRepository.findAll();
    }

    public void save(Request request) {
        requestRepository.save(request);
    }
}
