package br.sinqia.fepweb.controller;

import br.sinqia.fepweb.exception.ApiFepwebException;
import br.sinqia.fepweb.exception.EndpointException;
import br.sinqia.fepweb.model.EstadoCivil;
import br.sinqia.fepweb.model.Sexo;
import br.sinqia.fepweb.service.EstadoCivilService;
import br.sinqia.fepweb.service.SexoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Para o ambiente real, seria considerada outra configuração para o CrossOrigin
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/listagens")
public class ListasController {

    @Autowired
    SexoService sexoService;

    @Autowired
    EstadoCivilService estadoCivilService;

    private static final Logger logger = LoggerFactory.getLogger(ListasController.class);

    // Caso o model tivesse alguma informação que não pudesse ser exposta, bastaria omitir na serialização ou usar um DTO
    @RequestMapping(value = "/sexos", method = RequestMethod.GET)
    public ResponseEntity<List<Sexo>> buscarListagemSexo() throws EndpointException {
        try {
            List<Sexo> listagemSexoCadastrados = sexoService.buscarListagemSexo();

            return ResponseEntity.ok(listagemSexoCadastrados);
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/estados-civis", method = RequestMethod.GET)
    public ResponseEntity<List<EstadoCivil>> buscarListaEstadosCivis() throws EndpointException {
        try {
            List<EstadoCivil> listagemEstadosCivis = estadoCivilService.buscarListaEstadosCivis();

            return ResponseEntity.ok(listagemEstadosCivis);
        } catch (ApiFepwebException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }
}
