package com.Cinema.Cinema.Filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeAPI {

    private final FilmeService filmeService;

    @Autowired
    public FilmeAPI(FilmeService filmeService){
        this.filmeService = filmeService;
    }

//    @PostMapping("")
//    public ResponseEntity<Filme> cadastraFilme(@RequestBody Filme)

}
