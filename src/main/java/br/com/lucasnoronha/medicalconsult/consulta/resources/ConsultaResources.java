package br.com.lucasnoronha.medicalconsult.consulta.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.lucasnoronha.medicalconsult.consulta.domain.Consulta;
import br.com.lucasnoronha.medicalconsult.consulta.services.ConsultaService;

@RestController
@RequestMapping(value = "/consultas")
public class ConsultaResources {

    @Autowired
    private ConsultaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> BuscarConsulta(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarConsulta(id));
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> BuscarConsultas() {
        return ResponseEntity.ok(service.buscarConsultas());
    }

    @PostMapping
    public ResponseEntity<Consulta> CadastrarConsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(service.cadastrarConsulta(consulta));
    }

    @PutMapping("{id}")

    public ResponseEntity<Consulta> AtualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        return ResponseEntity.ok(service.atualizarConsulta(id, consulta));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> DeletarConsulta(@PathVariable Long id) {
        service.removerConsulta(id);
        return ResponseEntity.noContent().build();
    }

}
