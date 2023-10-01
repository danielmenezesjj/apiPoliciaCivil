package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
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
    private Pessoa pessoa;
    private Date fp_data;
    private String fp_bucket;
    private String fp_hash;


}
