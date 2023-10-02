package Api.policia.civil.de.mato.grosso.adapters.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExistException extends Exception {
    public EntityAlreadyExistException(String cidNome) {

    }
}
