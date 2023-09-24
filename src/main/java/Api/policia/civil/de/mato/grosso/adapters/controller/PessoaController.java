package Api.policia.civil.de.mato.grosso.adapters.controller;

import Api.policia.civil.de.mato.grosso.adapters.dtos.PessoaDTO;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity getAllPessoas(){
        var pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{pes_id}")
    public ResponseEntity getOnePessoa(@PathVariable Integer pes_id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByPesId(pes_id);
        if(pessoaOptional.isPresent()){
            return ResponseEntity.ok(pessoaOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity postPessoas(@RequestBody @Valid PessoaDTO data){
        Pessoa newPessoa = new Pessoa(data);
        var register = pessoaRepository.save(newPessoa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{pes_id}")
    @Transactional
    public ResponseEntity putPessoas(@PathVariable Integer pes_id, @RequestBody @Valid PessoaDTO data){
        var pessoa = pessoaRepository.getReferenceById(pes_id);
        pessoa.update(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pes_id}")
    public ResponseEntity delPessoa(@PathVariable Integer pes_id){
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByPesId(pes_id);
        if(pessoaOptional.isPresent()){
            Pessoa pessoa = pessoaOptional.get();
            pessoaRepository.delete(pessoa);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
