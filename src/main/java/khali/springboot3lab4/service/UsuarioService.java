package khali.springboot3lab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import khali.springboot3lab4.entity.Usuario;
import khali.springboot3lab4.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> buscarTodos() {
        return usuarioRepo.findAll();
    }

    public Usuario novo(Usuario usuario) {
        if( usuario == null ||
            usuario.getNome().isBlank() ||
            usuario.getSenha() == null ||
            usuario.getSenha().isBlank())
            {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

        return usuarioRepo.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return usuarioOp.get();
    }
    
}
