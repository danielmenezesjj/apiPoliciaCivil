package Api.policia.civil.de.mato.grosso.adapters.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotExistException extends Exception {

    public EntityNotExistException(Integer id) {

    }

}
