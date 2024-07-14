package com.thullyoo.encurtaUrl.controllers;

import com.thullyoo.encurtaUrl.entities.Link;
import com.thullyoo.encurtaUrl.entities.LinkRequest;
import com.thullyoo.encurtaUrl.entities.LinkResponse;
import com.thullyoo.encurtaUrl.services.LinkService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping()
    public ResponseEntity<LinkResponse> criarUrlEncurtada(@RequestBody LinkRequest linkRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.linkService.criarUrlEncurtado(linkRequest));
    }

    @GetMapping("/{id}")
    public void redirecionaUrl(@PathVariable("id") String id, HttpServletResponse httpServlet) throws IOException {
        Link link = linkService.procuraLink(id);

        httpServlet.sendRedirect(link.getOriginalUrl());
    }
}
