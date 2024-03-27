package br.sinqia.fepweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TB_SEXO")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Sexo implements Serializable {

    @Id
    @Column(name = "ID")
    public Integer id;

    @Column(name = "DESCRICAO")
    public String descricao;
}
