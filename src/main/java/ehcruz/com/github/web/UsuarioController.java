package ehcruz.com.github.web;

import ehcruz.com.github.domain.Usuario;
import ehcruz.com.github.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController extends ApplicationController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "cadastrar")
    public ResponseEntity<Usuario> cadastraUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario u = this.usuarioService.cadastrarNovo(usuario);
        return ResponseEntity.ok(u);
    }

    @GetMapping(value = "by/id/{id}")
    public ResponseEntity<Usuario> getUsuarioUsuarioById(@PathVariable("id") Long id) {
        Usuario u = this.usuarioService.getUsuarioPorId(id);
        return ResponseEntity.ok(u);
    }

    @GetMapping(value = "by/email/{email}")
    public ResponseEntity<Usuario> getUsuarioUsuarioByEmail(@PathVariable("email") String email) {
        Usuario u = this.usuarioService.getUsuarioPorEmail(email);
        return ResponseEntity.ok(u);
    }

    @GetMapping(value = "by/cpf/{cpf}")
    public ResponseEntity<Usuario> getUsuarioUsuarioByCpf(@PathVariable("cpf") String cpf) {
        Usuario u = this.usuarioService.getUsuarioPorCpf(cpf);
        return ResponseEntity.ok(u);
    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<Usuario> atualizarDadosUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario u = this.usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping(value = "remover/{id}")
    public ResponseEntity<Map<String, Boolean>> removeUsuario(@PathVariable("id") Long id) {
        this.usuarioService.removerUsuario(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("removido", true);
        return ResponseEntity.ok(response);
    }
}
