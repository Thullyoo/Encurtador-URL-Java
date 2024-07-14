package com.thullyoo.encurtaUrl.services;

import com.thullyoo.encurtaUrl.entities.Link;
import com.thullyoo.encurtaUrl.entities.LinkRequest;
import com.thullyoo.encurtaUrl.entities.LinkResponse;
import com.thullyoo.encurtaUrl.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public LinkResponse criarUrlEncurtado(LinkRequest linkRequest){

        String id;
        Boolean exists;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
            exists = linkRepository.findById(id).isPresent();
        } while (exists == true);

        Link link = new Link();

        link.setId(id);
        link.setOriginalUrl(linkRequest.url());
        link.setHoraCriação(LocalDateTime.now());
        link.setExpiraEm(link.getHoraCriação().plusMinutes(5));

        linkRepository.save(link);

        return new LinkResponse("http://localhost:8080/" + id);
    }


    public Link procuraLink(String id){

            Optional<Link> link = linkRepository.findById(id);

            if (link.isEmpty()){
                throw new RuntimeException("Link não encurtado");
            }

            return link.get();

    }
}
