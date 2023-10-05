package Api.policia.civil.de.mato.grosso.infrastructure.repository;

import Api.policia.civil.de.mato.grosso.core.domain.FotoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FotoPessoaRepository extends JpaRepository<FotoPessoa, Integer> {

    @Query("SELECT ft FROM FotoPessoa ft WHERE ft.pessoa.pes_id = :pessoaId")
    List<FotoPessoa> findAllByPessoaPesId(@Param("pessoaId") Integer pessoaId);

}
