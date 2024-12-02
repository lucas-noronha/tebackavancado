package br.com.lucasnoronha.medicalconsult.consulta.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.lucasnoronha.medicalconsult.consulta.domain.Consulta;
import br.com.lucasnoronha.medicalconsult.consulta.repositories.ConsultaRepository;
import br.com.lucasnoronha.medicalconsult.exception.ExceptionDataIntegrityViolation;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public Consulta cadastrarConsulta(Consulta consulta) {
        Consulta added = repository.save(consulta);
        return added;

    }

    public Consulta atualizarConsulta(Long id, Consulta consulta) {

        Consulta toUpdate = repository.findById(id).get();
        atualizarConsulta(consulta, toUpdate);
        return repository.save(toUpdate);

    }

    private void atualizarConsulta(Consulta newer, Consulta toUpdate) {
        toUpdate.setDataConsulta(newer.getDataConsulta());
        toUpdate.setEspecialidade(newer.getEspecialidade());
        toUpdate.setProfissional(newer.getProfissional());
    }

    public List<Consulta> buscarConsultas() {
        return repository.findAll();
    }

    public Consulta buscarConsulta(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Consulta não encontrada", id));
    }

    public void removerConsulta(Long id) {
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ExceptionDataIntegrityViolation("Não é possível excluir, porque há entidades relacionadas.");
        }
    }

}
