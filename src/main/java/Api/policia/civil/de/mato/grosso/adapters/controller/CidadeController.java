package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Cidade.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{cid_id}")
    public ResponseEntity getoneCity(@PathVariable Integer cid_id){
        Optional<Cidade> optionalCidade = cidadeRepository.findBycidid(cid_id);
        if(optionalCidade.isPresent()){
            return ResponseEntity.ok(optionalCidade.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createCity(@RequestBody @Valid CidadeDTO data){
        Cidade cidade = new Cidade(data);
        cidadeRepository.save(cidade);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cid_id}")
    @Transactional
    public ResponseEntity updateCity(@PathVariable Integer cid_id, @RequestBody CidadeDTO data){
        var cidade = cidadeRepository.getReferenceById(cid_id);
        if(cidade != null){
            cidade.update(data);
            return ResponseEntity.ok().build();
        }else{

            return ResponseEntity.notFound().build();
        }


    }

}
