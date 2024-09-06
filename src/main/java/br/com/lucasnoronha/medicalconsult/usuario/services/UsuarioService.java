package br.com.lucasnoronha.medicalconsult.usuario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.lucasnoronha.medicalconsult.usuario.domain.Usuario;
import br.com.lucasnoronha.medicalconsult.usuario.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return usuario;
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario salvar(Usuario usuario) {
        Usuario entity = usuarioRepository.save(usuario);
        return entity;

    }

    public Usuario update(Long id, Usuario entity) {
        Usuario actual = usuarioRepository.findById(id).get();
        if (actual != null) {
            Long safeId = actual.getIdUsuario();
            actual = entity;
            actual.setIdUsuario(safeId);
            usuarioRepository.save(actual);
            return actual;
        }
        return null;
    }

    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null) {
            usuarioRepository.deleteById(id);
        }
    }

}
