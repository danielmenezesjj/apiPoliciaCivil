package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.LotacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name = "Lotacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lot_id;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    private Date lot_data_lotacao;

    private Date lot_data_remocao;

    private String lot_portaria;

    public Lotacao(LotacaoDTO data) {

        this.lot_data_lotacao = data.lot_data_lotacao();
        this.lot_data_remocao = data.lot_data_remocao();
        this.pessoa = data.pessoa();
        this.unidade = data.unidade();

    }


    public void update(LotacaoDTO data) {

        if(data.lot_data_lotacao() != null){
            this.lot_data_lotacao = data.lot_data_lotacao();
        }
        if(data.lot_data_remocao() != null){
            this.lot_data_remocao = data.lot_data_remocao();
        }
        if(data.pessoa() != null){
            this.pessoa = data.pessoa();
        }
        if(data.unidade() != null){
            this.unidade = data.unidade();
        }

    }
}
