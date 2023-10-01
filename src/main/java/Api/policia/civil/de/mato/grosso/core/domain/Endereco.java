package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.CidadeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity(name = "Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int end_id;
    private String end_tipo_logradouro;
    private String end_logradouro;
    private String end_numero;
    private String end_bairro;
    @ManyToOne
    @JoinColumn(name = "cid_id")
    private Cidade cidade;
    @ManyToMany
    @JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "pes_id"))
    private List<Pessoa> pessoaList;

    @ManyToMany
    @JoinTable(name = "unidade_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "unid_id"))
    private List<Unidade> unidadeList;

}
