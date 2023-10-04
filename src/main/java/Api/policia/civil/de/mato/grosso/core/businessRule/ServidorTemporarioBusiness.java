package Api.policia.civil.de.mato.grosso.core.businessRule;


import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorTemporarioDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import Api.policia.civil.de.mato.grosso.core.domain.ServidorTemporario;
import Api.policia.civil.de.mato.grosso.core.domain.Unidade;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa.PessoaRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.ServidorTemporario.ServidorTemporarioRepository;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Unidade.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ServidorTemporarioBusiness {

    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;



    public Page<ServidorTemporario> findAll(Pageable pageable){
        return servidorTemporarioRepository.findAll(pageable);
    }


    public ServidorTemporario findOne(Integer id) throws EntityNotExistException {
        Optional<ServidorTemporario> optionalServidorTemporario = servidorTemporarioRepository.findById(id);
        if(!optionalServidorTemporario.isPresent()){
            throw new EntityNotExistException(id);
        }
        return optionalServidorTemporario.get();
    }

    public ServidorTemporario createServidorTemporario (ServidorTemporario servidorTemporario) throws EntityNotExistException {
      return servidorTemporarioRepository.save(servidorTemporario);
    }

    public void updateServidorTemporario(Integer id, ServidorTemporarioDTO data) throws EntityNotExistException {
        Optional<ServidorTemporario> servidorTemporarioOptional = servidorTemporarioRepository.findById(id);
        if (servidorTemporarioOptional.isPresent()) {
            ServidorTemporario servidorTemporario = servidorTemporarioOptional.get();
            servidorTemporario.update(data);
        }else{
            throw new EntityNotExistException(id);
        }
    }

    public void deleteServidorTemporario(Integer id) throws  EntityNotExistException{
        Optional<ServidorTemporario> optionalServidorTemporario = servidorTemporarioRepository.findById(id);
        if(optionalServidorTemporario.isPresent()){
            ServidorTemporario servidorTemporario = optionalServidorTemporario.get();
            servidorTemporarioRepository.delete(servidorTemporario);
        }else{
            throw new EntityNotExistException(id);
        }
    }




}
