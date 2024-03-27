package br.sinqia.fepweb.service;

import br.sinqia.fepweb.exception.ApiFepwebException;
import br.sinqia.fepweb.model.EstadoCivil;
import br.sinqia.fepweb.repository.EstadoCivilRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilService {

    @Autowired
    EstadoCivilRepository estadoCivilRepository;

    private static final Logger logger = LoggerFactory.getLogger(EstadoCivilService.class);

    public List<EstadoCivil> buscarListaEstadosCivis() throws ApiFepwebException {
        try {
            List<EstadoCivil> listaEstadosCivis = estadoCivilRepository.findAll();

            return listaEstadosCivis;
        } catch (Exception e) {
            logger.error("Ocorreu um erro aoo recuperar listagem de estados civis cadastrados: " + e.getMessage(), e);
            throw new ApiFepwebException("Ocorreu um erro aoo recuperar listagem de estados civis cadastrados: " + e.getMessage());
        }
    }
}
