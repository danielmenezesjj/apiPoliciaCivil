package Api.policia.civil.de.mato.grosso.infrastructure.repository.Endereco;

import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("SELECT e FROM Endereco e where e.end_id = :endId")
    Optional<Endereco> findByendid(Integer endId);

    Optional<Object> findByCidadeAndBairroAndTipoLogradouroAndLogradouroAndNumero(Cidade cidade, String endBairro, String endTipoLogradouro, String endLogradouro, String numero);
}
