package ehcruz.com.github.service;

import ehcruz.com.github.domain.Usuario;
import ehcruz.com.github.domain.UsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Usuario getInformacoesByEmailAndCpf(UsuarioLogin usuarioLogin) {
        return this.usuarioService.getUsuarioLogin(usuarioLogin.getEmail(), usuarioLogin.getCpf());
    }
}
