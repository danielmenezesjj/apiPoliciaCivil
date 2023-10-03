package Api.policia.civil.de.mato.grosso.adapters.dtos;

import Api.policia.civil.de.mato.grosso.core.domain.Cidade;
import Api.policia.civil.de.mato.grosso.core.domain.Pessoa;

public record EnderecoDTO(String tipoLogradouro, String logradouro, String numero, String bairro, Cidade cidade, Pessoa pessoa) {
}
