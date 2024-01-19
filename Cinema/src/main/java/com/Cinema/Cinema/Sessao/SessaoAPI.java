package com.Cinema.Cinema.Sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessao")
public class SessaoAPI {

    private final SessaoService sessaoService;

    @Autowired
    public SessaoAPI(SessaoService sessaoService){
        this.sessaoService = sessaoService;
    }

    @PostMapping("")
    public ResponseEntity<Sessao> cadastrarSessao(@RequestBody Sessao sessao){
        return ResponseEntity.ok(this.sessaoService.cadastrarSessao(sessao));
    }
}
