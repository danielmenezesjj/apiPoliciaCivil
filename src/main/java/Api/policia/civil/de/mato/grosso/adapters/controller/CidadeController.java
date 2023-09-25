package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity getAllCity(){
        var allCity = cidadeRepository.findAll();
        return ResponseEntity.ok(allCity);
    }

    @PostMapping
    public ResponseEntity createCity(@RequestBody @Valid CidadeDTO data){
        Cidade cidade = new Cidade(data);
        cidadeRepository.save(cidade);
        return ResponseEntity.ok().build();
    }

}
