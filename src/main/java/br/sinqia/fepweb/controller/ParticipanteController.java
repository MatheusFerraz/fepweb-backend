package br.sinqia.fepweb.controller;

import br.sinqia.fepweb.exception.ApiFepwebException;
import br.sinqia.fepweb.exception.EndpointException;
import br.sinqia.fepweb.model.Participante;
import br.sinqia.fepweb.payload.ParticipanteResponse;
import br.sinqia.fepweb.service.ParticipanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * OBSERVAÇÕES
 * Para o ambiente real, seria considerada outra configuração para o CrossOrigin
 * Caso o model tivesse alguma informação que não pudesse ser exposta, bastaria omitir na serialização ou usar um DTO
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    ParticipanteService participanteService;

    private static final Logger logger = LoggerFactory.getLogger(ParticipanteController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Participante> salvarDadosParticipante(@RequestBody Participante participante) throws EndpointException {
        try {
            Participante participantePersistido = participanteService.salvarParticipante(participante);

            return ResponseEntity.ok(participantePersistido);
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Participante> buscarParticipantePorCodigoIdentificador(@RequestParam Long codigoIdentificador) throws EndpointException {
        try {
            Participante participanteBusca = participanteService.buscarParticipantePorCodigoIdentificador(codigoIdentificador);

            return ResponseEntity.ok(participanteBusca);
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/listagem", method = RequestMethod.GET)
    public ResponseEntity<List<ParticipanteResponse>> buscarListagemParticipantes() throws EndpointException {
        try {
            List<ParticipanteResponse> listaParticipantesCadastrados = participanteService.buscarListagemParticipantes();

            return ResponseEntity.ok(listaParticipantesCadastrados);
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/{codigoIdentificador}", method = RequestMethod.DELETE)
    public ResponseEntity<String> excluirParticipante(@PathVariable Long codigoIdentificador) throws EndpointException {
        try {
            participanteService.excluirParticipante(codigoIdentificador);

            return ResponseEntity.ok("Participante excluído com sucesso!");
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }
}
