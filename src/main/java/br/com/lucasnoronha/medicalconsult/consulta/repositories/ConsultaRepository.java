package br.com.lucasnoronha.medicalconsult.consulta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasnoronha.medicalconsult.consulta.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
