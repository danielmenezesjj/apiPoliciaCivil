package Api.policia.civil.de.mato.grosso.adapters.controller;

import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import Api.policia.civil.de.mato.grosso.core.domain.Unidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.UnidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    UnidadeRepository unidadeRepository;

    @GetMapping
    public ResponseEntity getAllUnidade(){
        var unidades = unidadeRepository.findAll();
        return ResponseEntity.ok(unidades);
    }


    @GetMapping("/{unid_id}")
    public ResponseEntity getOneUnidade(@PathVariable Integer unid_id){
        Optional<Unidade> unidadeOptional = unidadeRepository.findByUnidId(unid_id);
        if(unidadeOptional.isPresent()){
            return ResponseEntity.ok(unidadeOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity createUnidade(@RequestBody @Valid UnidadeDTO data){
        Unidade unidade = new Unidade(data);
        unidadeRepository.save(unidade);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{unid_id}")
    @Transactional
    public ResponseEntity updateUnidade(@PathVariable Integer unid_id, @RequestBody @Valid UnidadeDTO data){
        var unidade = unidadeRepository.getReferenceById(unid_id);
        unidade.update(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{unid_id}")
    public ResponseEntity deleteUnidade(@PathVariable Integer unid_id){
        Optional<Unidade> unidadeOptional = unidadeRepository.findByUnidId(unid_id);
        if(unidadeOptional.isPresent()){
            Unidade unidade = unidadeOptional.get();
            unidadeRepository.delete(unidade);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
