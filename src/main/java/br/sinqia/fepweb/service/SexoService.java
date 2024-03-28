package br.sinqia.fepweb.service;

import br.sinqia.fepweb.exception.ApiFepwebException;
import br.sinqia.fepweb.model.Sexo;
import br.sinqia.fepweb.repository.SexoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexoService {

    @Autowired
    SexoRepository sexoRepository;

    private static final Logger logger = LoggerFactory.getLogger(SexoService.class);

    public List<Sexo> buscarListagemSexo() throws ApiFepwebException {
        try {
            List<Sexo> listaSexoCadastrados = sexoRepository.findAll();

            return listaSexoCadastrados;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao recuperar listagem de sexo cadastrados: " + e.getMessage(), e);
            throw new ApiFepwebException("Ocorreu um erro ao recuperar listagem de sexo cadastrados: " + e.getMessage());
        }
    }
}
