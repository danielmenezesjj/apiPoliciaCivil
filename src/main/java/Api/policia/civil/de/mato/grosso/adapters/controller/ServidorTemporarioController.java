package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorTemporarioDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.CidadeBusiness;
import Api.policia.civil.de.mato.grosso.core.businessRule.ServidorTemporarioBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorTemporario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servidortemporario")
public class ServidorTemporarioController {


    @Autowired
    private ServidorTemporarioBusiness servidorTemporarioBusiness;


    @GetMapping
    public ResponseEntity<Page<ServidorTemporario>> getAllServidorTemp(Pageable pageable) {
        Page<ServidorTemporario> ServidorTemp = servidorTemporarioBusiness.findAll(pageable);
        return ResponseEntity.ok(ServidorTemp);
    }

    @GetMapping("/{id}")
    public ResponseEntity getoneServidorTemporario(@PathVariable Integer id) throws EntityNotExistException {
        var servidorTemporario = servidorTemporarioBusiness.findOne(id);
        return ResponseEntity.ok(servidorTemporario);
    }

    @PostMapping
    public ResponseEntity createServidorTemporario(@RequestBody @Valid ServidorTemporarioDTO data) throws EntityNotExistException {
        System.out.println(data);
        ServidorTemporario servidorTemporario = new ServidorTemporario(data);
        ServidorTemporario createServidorTemporario = servidorTemporarioBusiness.createServidorTemporario(servidorTemporario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServidorTemporario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateServidorTemporario(@PathVariable Integer id, @RequestBody ServidorTemporarioDTO data) throws EntityNotExistException {
            servidorTemporarioBusiness.updateServidorTemporario(id, data);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteServidorTemporario(@PathVariable Integer id) throws EntityNotExistException {
        servidorTemporarioBusiness.deleteServidorTemporario(id);
        return ResponseEntity.noContent().build();
    }

}