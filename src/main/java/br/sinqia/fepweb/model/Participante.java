package br.sinqia.fepweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// As informações do Conjuge poderiam ser feitas como um auto relacionamento
@Table(name = "TB_PARTICIPANTE")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Participante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO_EXTERNO", nullable = false, unique = true)
    private Long codigoExterno;

    @Column(name = "NOME", length = 500, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @Column(name = "IS_CPF_APLICAVEL", nullable = false)
    private int isCpfAplicavel;

    // Aqui também poderia ser usado mapeamento de relacionamento com o JPA ou até mesmo ENUM
    @Column(name = "ID_SEXO", nullable = false)
    private Integer idSexo;

    // Aqui também poderia ser usado mapeamento de relacionamento com o JPA ou até mesmo ENUM
    @Column(name = "ID_ESTADO_CIVIL", nullable = false)
    private Integer idEstadoCivil;

    @Column(name = "NR_DOCUMENTO_IDENTIFICACAO", nullable = false, unique = true)
    private String numeroDocumentoIdentificacao;

    @Column(name = "OBSERVACAO", length = 1000)
    private String observacao;

    @Column(name = "NR_TELEFONE", length = 13, unique = true)
    private String numeroTelefone;

    @Column(name = "NR_TELEFONE_CELULAR", length = 13, unique = true)
    private String numeroTelefoneCelular;

    @Column(name = "IS_VALIDADE_FICHA_CADASTRAL_APLICAVEL", nullable = false)
    private int isValidadeFichaAplicavel;

    @Column(name = "DATA_VALIDADE_FICHA_CADASTRAL")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeFichaCadastral;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "IS_HABILITA_ENVIO_TOKEN_SMS", nullable = false)
    private int isHabilitaEnvioTokenSms;

    @Column(name = "IS_ATIVO", nullable = false)
    private int isAtivo;

    @Column(name = "IS_PESSOA_POLITICAMENTE_EXPOSTA", nullable = false)
    private int isPessoaPoliticamenteExposta;

    @Column(name = "IS_ASSINA_ELETRONICAMENTE", nullable = false)
    private int isAssinaEletronicamente;
}
