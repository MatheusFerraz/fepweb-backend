package br.sinqia.fepweb.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteResponse implements Serializable {

    private Long codigoIdentificador;
    private Long codigoExterno;
    private String nome;
    private String cpf;
    private String numeroTelefone;
    private int isAssinaEletronicamente;
    private int isAtivo;
}
