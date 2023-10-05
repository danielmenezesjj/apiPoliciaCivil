package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;

public record FotoPessoaDTO(String imagemBase64, Pessoa pessoa) {
}
