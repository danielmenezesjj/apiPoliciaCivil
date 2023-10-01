package Api.policia.civil.de.mato.grosso.core.domain;


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
    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;
    private String se_matricula;



}
