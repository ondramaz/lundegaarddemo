package com.lundegaard.demo.controllers;

import com.lundegaard.demo.entities.Request;
import com.lundegaard.demo.services.RequestKindService;
import com.lundegaard.demo.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RequestController {

    private final RequestService requestService;
    private final RequestKindService requestKindService;

    @Autowired
    public RequestController(RequestService requestService, RequestKindService requestKindService) {
        this.requestService = requestService;
        this.requestKindService = requestKindService;
    }

    // handler method for showing add request form
    @GetMapping("/show_add_request")
    public String showRequestForm(Request request, Model model) {
        model.addAttribute("requestKindList", requestKindService.getRequestKindList());
        return "add-request";
    }

    // handler method for adding request
    @PostMapping("/add_request")
    public String addUser(@Valid Request request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("requestKindList", requestKindService.getRequestKindList());
            return "add-request";
        }
        requestService.save(request);

        model.addAttribute("requests", requestService.getRequestList());
        return "index";
    }
}