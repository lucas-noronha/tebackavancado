package br.com.lucasnoronha.medicalconsult;

import br.com.lucasnoronha.medicalconsult.usuario.domain.Usuario;
import br.com.lucasnoronha.medicalconsult.usuario.repositories.UsuarioRepository;
import br.com.lucasnoronha.medicalconsult.usuario.services.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService; // O serviço que estamos testando

    @Mock
    private UsuarioRepository usuarioRepository; // O repositório que será simulado

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    public void testGetById() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.getById(1L);

        assertEquals(usuario, result);
    }

    @Test
    public void testGetAll() {
        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(new Usuario()));

        var result = usuarioService.getAll();

        assertEquals(1, result.size());
    }

    @Test
    public void testSalvar() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.salvar(usuario);

        assertEquals(usuario, result);
    }

    @Test
    public void testUpdate() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        usuario.setNomeUsuario("Novo Nome"); // Supondo que você tenha um método setNome
        Usuario result = usuarioService.update(1L, usuario);

        assertEquals(usuario, result);
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void testDelete() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        usuarioService.delete(1L);

        verify(usuarioRepository).deleteById(1L);
    }
}
