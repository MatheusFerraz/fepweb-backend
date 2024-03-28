package br.sinqia.fepweb.service;

import br.sinqia.fepweb.exception.ApiFepwebException;
import br.sinqia.fepweb.model.Participante;
import br.sinqia.fepweb.payload.ParticipanteResponse;
import br.sinqia.fepweb.repository.ParticipanteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    ParticipanteRepository participanteRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ParticipanteService.class);

    public Participante salvarParticipante(Participante participante) throws ApiFepwebException {
        try {
            Participante participantePersistido = participanteRepository.saveAndFlush(participante);

            return participantePersistido;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao salvar dados do participante: " + e.getMessage(), e);
            throw new ApiFepwebException("Ocorreu um erro ao salvar dados do participante: " + e.getMessage());
        }
    }

    public Participante buscarParticipantePorCodigoIdentificador(Long codigoIdentificador) throws ApiFepwebException {
        Participante participante = participanteRepository.findById(codigoIdentificador)
                .orElseThrow(() -> new ApiFepwebException("Participante não encontrado a partir do código identificador informado."));

        return participante;
    }

    public void excluirParticipante(Long codigoIdentificador) throws ApiFepwebException {
        try {
            participanteRepository.deleteById(codigoIdentificador);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao excluir participante por código identificador: " + e.getMessage(), e);
            throw new ApiFepwebException("Ocorreu um erro ao excluir participante por código identificador: " + e.getMessage());
        }
    }

    public List<ParticipanteResponse> buscarListagemParticipantes() throws ApiFepwebException {
        try {
            String sqlQuery = "SELECT p.ID as codigoIdentificador, p.CODIGO_EXTERNO as codigoExterno, p.NOME as nome, " +
                    "p.CPF as cpf, p.NR_TELEFONE as numeroTelefone, p.IS_ASSINA_ELETRONICAMENTE as isAssinaEletronicamente, " +
                    "p.IS_ATIVO as isAtivo from TB_PARTICIPANTE p";

            List<ParticipanteResponse> listaParticipantes = jdbcTemplate.query(
                    sqlQuery,
                    (rs, rowNum) ->
                            new ParticipanteResponse(
                                    rs.getLong("codigoIdentificador"),
                                    rs.getLong("codigoExterno"),
                                    rs.getString("nome"),
                                    rs.getString("cpf"),
                                    rs.getString("numeroTelefone"),
                                    rs.getInt("isAssinaEletronicamente"),
                                    rs.getInt("isAtivo")
                            ));

            return listaParticipantes;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao buscar a lista de participantes: " + e.getMessage(), e);
            throw new ApiFepwebException("Ocorreu um erro ao buscar a lista de participantes: " + e.getMessage());
        }
    }
}
