package Api.policia.civil.de.mato.grosso.adapters.controller;


import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorEfetivoDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorTemporarioDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.businessRule.ServidorEfetivoBusiness;
import Api.policia.civil.de.mato.grosso.core.businessRule.ServidorTemporarioBusiness;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorEfetivo;
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
@RequestMapping("/servidorefetivo")
public class ServidorEfetivoController {


    @Autowired
    private ServidorEfetivoBusiness servidorEfetivoBusiness;


    @GetMapping
    public ResponseEntity<Page<ServidorEfetivo>> getAllServidorEfetivo(Pageable pageable) {
        Page<ServidorEfetivo> ServidorEfetivo = servidorEfetivoBusiness.findAll(pageable);
        return ResponseEntity.ok(ServidorEfetivo);
    }

    @GetMapping("/{id}")
    public ResponseEntity getoneServidorEfetivo(@PathVariable Integer id) throws EntityNotExistException {
        var servidorEfetivo = servidorEfetivoBusiness.findOne(id);
        return ResponseEntity.ok(servidorEfetivo);
    }

    @PostMapping
    public ResponseEntity createServidorEfetivo(@RequestBody @Valid ServidorEfetivoDTO data) throws EntityNotExistException {
        ServidorEfetivo servidorEfetivo = new ServidorEfetivo(data);
        ServidorEfetivo createServidorEfetivo = servidorEfetivoBusiness.createServidorTemporario(servidorEfetivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServidorEfetivo);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateServidorEfetivo(@PathVariable Integer id, @RequestBody ServidorEfetivoDTO data) throws EntityNotExistException {
            servidorEfetivoBusiness.updateServidorEfetivo(id, data);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteServidorEfetivo(@PathVariable Integer id) throws EntityNotExistException {
        servidorEfetivoBusiness.deleteServidorEfetivo(id);
        return ResponseEntity.noContent().build();
    }

}