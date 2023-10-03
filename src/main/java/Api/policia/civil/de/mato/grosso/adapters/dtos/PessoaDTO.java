package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Endereco;

import java.util.Date;

public record PessoaDTO(String pes_nome, Date pes_data_nascimento, String pes_sexo, String pes_mae, String pes_pai, Endereco endereco) {
}
