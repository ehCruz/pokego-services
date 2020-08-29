package ehcruz.com.github.service;

import ehcruz.com.github.domain.Usuario;
import ehcruz.com.github.domain.UsuarioLogin;

public interface LoginService {

    Usuario getInformacoesByEmailAndCpf(UsuarioLogin usuarioLogin);

}
