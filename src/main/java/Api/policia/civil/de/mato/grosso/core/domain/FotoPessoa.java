package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.FotoPessoaDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name = "FotoPessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FotoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fp_id;
    @ManyToOne
    @JoinColumn(name = "pes_id")
    @JsonIgnore
    private Pessoa pessoa;
    @Lob
    @Column(name = "imagemBase64", columnDefinition = "LONGBLOB")
    private byte[] imagemBase64;


    public FotoPessoa(FotoPessoaDTO data) {
        this.imagemBase64 = data.imagemBase64().getBytes();
        this.pessoa = data.pessoa();
    }
}
