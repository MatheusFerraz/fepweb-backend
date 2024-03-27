package br.sinqia.fepweb.repository;

import br.sinqia.fepweb.model.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Integer> {

}
