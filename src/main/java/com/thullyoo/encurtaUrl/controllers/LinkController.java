package com.thullyoo.encurtaUrl.controllers;

import com.thullyoo.encurtaUrl.entities.LinkRequest;
import com.thullyoo.encurtaUrl.entities.LinkResponse;
import com.thullyoo.encurtaUrl.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping()
    public ResponseEntity<LinkResponse> criarUrlEncurtada(@RequestBody LinkRequest linkRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.linkService.criarUrlEncurtado(linkRequest));
    }
}
