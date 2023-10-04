package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorTemporarioDTO;
import Api.policia.civil.de.mato.grosso.adapters.dtos.UnidadeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name = "ServidorTemporario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServidorTemporario {


    @Id
    @GeneratedValue
    private Integer id;
    private Date st_data_admissao;
    private Date st_data_demissao;


    @ManyToOne
    @JoinColumn(name = "pes_id")
    @JsonIgnore
    private Pessoa pessoa;



    public ServidorTemporario(ServidorTemporarioDTO data){
        this.st_data_admissao = data.st_data_admissao();
        this.st_data_demissao = data.st_data_demissao();
        this.pessoa = data.pessoa();

    }


    public void update(ServidorTemporarioDTO data) {
        if(data.st_data_admissao() != null){
            this.st_data_admissao = data.st_data_admissao();
        }
        if(data.st_data_demissao() != null){
            this.st_data_demissao = data.st_data_demissao();
        }
        if(data.pessoa() != null){
            this.pessoa = data.pessoa();
        }
    }
}
