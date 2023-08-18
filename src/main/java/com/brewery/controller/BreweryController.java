package com.brewery.controller;

import com.brewery.model.Brewery;
import com.brewery.service.SearchService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BreweryController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/{name}")
    @ApiOperation("search for a brewery by name")
    public ResponseEntity<Brewery[]> search(@PathVariable String name) {
        log.info("search for a brewery by name, name=" + name);
        Brewery[] results = searchService.search(name);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("get brewery detail by id")
    public ResponseEntity<Brewery> search(@PathVariable Integer id) {
        log.info("get brewery detail by id, id=" + id);
        Brewery results = searchService.detail(id);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}
