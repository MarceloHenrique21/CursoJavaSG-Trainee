package com.Hospital.Hospital.Leito;


import com.Hospital.Hospital.DTO.LeitoProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leito")
public class LeitoAPI {

    private final LeitoService leitoService;

    @Autowired
    public LeitoAPI(LeitoService leitoService){
        this.leitoService = leitoService;
    }

    @GetMapping("/ocupados")
    public ResponseEntity<Page<LeitoProjectionDTO>> getLeitosOcupados(Pageable pageable ) {
        return ResponseEntity.ok(this.leitoService.getLeitosOcupados(pageable));
    }

    @GetMapping("/ocupados-teste")
    public ResponseEntity<Page<Leito>> getLeitosOcupadosTeste(Pageable pageable ) {
        return ResponseEntity.ok(this.leitoService.getLeitosOcupadosTeste(pageable));
    }
}
