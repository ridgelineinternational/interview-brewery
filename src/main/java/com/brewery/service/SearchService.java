package com.brewery.service;

import com.brewery.model.Brewery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Service
@Slf4j
public class SearchService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String SEARCH_URL = "https://api.openbrewerydb.org/breweries/search?query={0}";
    private final String DETAIL_URL = "https://api.openbrewerydb.org/breweries/{0}";

    public Brewery[] search(String name) {
        return this.fetch(name);
    }

    public Brewery detail(Integer id) {
        return this.fetch(id);
    }

    private Brewery[] fetch(String name) {
        String url = MessageFormat.format(this.SEARCH_URL, name);
        log.info("url=" + url);
        ResponseEntity<Brewery[]> results = this.restTemplate.getForEntity(url, Brewery[].class);
        return results.getBody();
    }

    private Brewery fetch(Integer id) {
        String url = MessageFormat.format(this.DETAIL_URL, id);
        log.info("url=" + url);
        ResponseEntity<Brewery> results = this.restTemplate.getForEntity(url, Brewery.class);
        return results.getBody();
    }
}
