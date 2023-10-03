package Api.policia.civil.de.mato.grosso.core.businessRule;

import Api.policia.civil.de.mato.grosso.adapters.dtos.EnderecoDTO;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityAlreadyExistException;
import Api.policia.civil.de.mato.grosso.adapters.exceptions.EntityNotExistException;
import Api.policia.civil.de.mato.grosso.core.domain.Endereco;
import Api.policia.civil.de.mato.grosso.infrastructure.repository.Endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class EnderecoBusiness {
    @Autowired
    private EnderecoRepository enderecoRepository;


    public Page<Endereco> findAll(Pageable pageable){
        return enderecoRepository.findAll(pageable);

    }

    public Endereco findOne(Integer end_id) throws EntityNotExistException{
        Optional<Endereco>optionalEndereco = enderecoRepository.findByendid(end_id);
        if(!optionalEndereco.isPresent()){
            throw new EntityNotExistException(end_id);
        }
        return optionalEndereco.get();
    }

    public Endereco createEndereco(Endereco endereco) throws EntityAlreadyExistException {
        if(enderecoRepository.findByCidadeAndBairroAndTipoLogradouroAndLogradouroAndNumero(
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getTipoLogradouro(),
                endereco.getLogradouro(),
                endereco.getNumero()
        ).isPresent()){
            throw new EntityAlreadyExistException(
                    endereco.getBairro() + " " +
                    endereco.getTipoLogradouro() + " "+
                    endereco.getLogradouro() + " "+
                    endereco.getNumero() + " "+
                    endereco.getNumero());
        }
        return enderecoRepository.save(endereco);
    }

    public void updateEndereco(Integer end_id, EnderecoDTO data) throws EntityNotExistException {
        Optional<Endereco> optionalEndereco = enderecoRepository.findByendid(end_id);
        if (optionalEndereco.isPresent()) {
            Endereco endereco = optionalEndereco.get();
            endereco.update(data);
            enderecoRepository.save(endereco);
        } else {
            throw new EntityNotExistException(end_id);
        }
    }

    public void deleteEndereco(Integer end_id) throws EntityNotExistException{
        Optional<Endereco>optionalEndereco = enderecoRepository.findByendid(end_id);
        if(!optionalEndereco.isPresent()){
            throw new EntityNotExistException(end_id);
        }
        Endereco endereco = optionalEndereco.get();
        enderecoRepository.delete(endereco);
    }




}
