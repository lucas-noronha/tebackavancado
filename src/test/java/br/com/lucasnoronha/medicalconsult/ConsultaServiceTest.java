package br.com.lucasnoronha.medicalconsult;

import br.com.lucasnoronha.medicalconsult.consulta.domain.Consulta;
import br.com.lucasnoronha.medicalconsult.consulta.repositories.ConsultaRepository;
import br.com.lucasnoronha.medicalconsult.consulta.services.ConsultaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsultaServiceTest {

    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(1L);

        when(repository.save(consulta)).thenReturn(consulta);

        Consulta result = consultaService.cadastrarConsulta(consulta);

        assertEquals(consulta, result);
    }

    @Test
    public void testAtualizarConsulta() {
        Consulta consultaAtual = new Consulta();
        consultaAtual.setIdConsulta(1L);
        consultaAtual.setDataConsulta("2024-10-30");
        consultaAtual.setEspecialidade("Cardiologia");
        consultaAtual.setProfissional("Dr. João");

        when(repository.findById(1L)).thenReturn(Optional.of(consultaAtual));

        Consulta consultaNova = new Consulta();
        consultaNova.setDataConsulta("2024-11-05");
        consultaNova.setEspecialidade("Pediatria");
        consultaNova.setProfissional("Dr. Maria");

        consultaService.atualizarConsulta(1L, consultaNova);

        assertEquals(consultaNova.getDataConsulta(), consultaNova.getDataConsulta());
        assertEquals(consultaNova.getEspecialidade(), consultaNova.getEspecialidade());
        assertEquals(consultaNova.getProfissional(), consultaNova.getProfissional());
        verify(repository).save(consultaAtual);
    }

    @Test
    public void testBuscarConsultas() {
        when(repository.findAll()).thenReturn(Collections.singletonList(new Consulta()));

        var result = consultaService.buscarConsultas();

        assertEquals(1, result.size());
    }

    @Test
    public void testBuscarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(consulta));

        Consulta result = consultaService.buscarConsulta(1L);

        assertEquals(consulta, result);
    }

    @Test
    public void testRemoverConsulta() {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(consulta));

        consultaService.removerConsulta(1L);

        verify(repository).deleteById(1L);
    }
}
