package Api.policia.civil.de.mato.grosso.infrastructure.repository.Pessoa;

import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query("SELECT p FROM Pessoa p WHERE p.pes_id = :pes_id")
    Optional<Pessoa> findByPesId(@Param("pes_id") Integer pes_id);
}
