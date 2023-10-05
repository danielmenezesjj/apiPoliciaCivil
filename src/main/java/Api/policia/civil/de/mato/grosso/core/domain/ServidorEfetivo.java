package Api.policia.civil.de.mato.grosso.core.domain;


import Api.policia.civil.de.mato.grosso.adapters.dtos.ServidorEfetivoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name = "ServidorEfetivo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServidorEfetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pes_id")
    @JsonIgnore
    private Pessoa pessoa;
    private String se_matricula;


    public ServidorEfetivo(ServidorEfetivoDTO data){
        this.se_matricula = data.se_matricula();
        this.pessoa = data.pessoa();
    }


    public void update(ServidorEfetivoDTO data) {
        if(data.se_matricula() != null){
            this.se_matricula = data.se_matricula();
        }
        if(data.pessoa() != null){
            this.pessoa = data.pessoa();
        }
    }
}
