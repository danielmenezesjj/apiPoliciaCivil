package Api.policia.civil.de.mato.grosso.adapters.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrosResponse> erroNotFound(){
        String mensagemDeAviso = "Os dados não foram localizados.";
        ErrosResponse errosResponse = new ErrosResponse(mensagemDeAviso);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errosResponse);
    }

}
