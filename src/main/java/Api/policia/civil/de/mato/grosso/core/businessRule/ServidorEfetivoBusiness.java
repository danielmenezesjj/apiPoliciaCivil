package Api.policia.civil.de.mato.grosso.core.businessRule;


import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorEfetivoDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorTemporarioDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorEfetivo;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorTemporario;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorEfetivo.ServidorEfetivoRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorTemporario.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ServidorEfetivoBusiness {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;



    public Page<ServidorEfetivo> findAll(Pageable pageable){
        return servidorEfetivoRepository.findAll(pageable);
    }


    public ServidorEfetivo findOne(Integer id) throws EntityNotExistException {
        Optional<ServidorEfetivo> optionalServidorEfetivo = servidorEfetivoRepository.findById(id);
        if(!optionalServidorEfetivo.isPresent()){
            throw new EntityNotExistException(id);
        }
        return optionalServidorEfetivo.get();
    }

    public ServidorEfetivo createServidorTemporario (ServidorEfetivo servidorTemporario) throws EntityNotExistException {
      return servidorEfetivoRepository.save(servidorTemporario);
    }

    public void updateServidorEfetivo(Integer id, ServidorEfetivoDTO data) throws EntityNotExistException {
        Optional<ServidorEfetivo> servidorEfetivoOptional = servidorEfetivoRepository.findById(id);
        if (servidorEfetivoOptional.isPresent()) {
            ServidorEfetivo servidorEfetivo = servidorEfetivoOptional.get();
            servidorEfetivo.update(data);
        }else{
            throw new EntityNotExistException(id);
        }
    }

    public void deleteServidorEfetivo(Integer id) throws  EntityNotExistException{
        Optional<ServidorEfetivo> optionalServidorEfetivo = servidorEfetivoRepository.findById(id);
        if(optionalServidorEfetivo.isPresent()){
            ServidorEfetivo servidorEfetivo = optionalServidorEfetivo.get();
            servidorEfetivoRepository.delete(servidorEfetivo);
        }else{
            throw new EntityNotExistException(id);
        }
    }




}
