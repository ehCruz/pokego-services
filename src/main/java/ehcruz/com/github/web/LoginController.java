package ehcruz.com.github.web;

import ehcruz.com.github.domain.Usuario;
import ehcruz.com.github.domain.UsuarioLogin;
import ehcruz.com.github.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "login")
public class LoginController extends ApplicationController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioLogin usuarioLogin) {
        Usuario usuario = this.loginService.getInformacoesByEmailAndCpf(usuarioLogin);
        if (usuario == null) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Usuário informado não possuí cadastro.");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(usuario);
    }

}
