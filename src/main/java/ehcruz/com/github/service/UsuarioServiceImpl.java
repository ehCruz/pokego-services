package ehcruz.com.github.service;

import ehcruz.com.github.dao.UsuarioDao;
import ehcruz.com.github.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Transactional(readOnly = false)
    @Override
    public Usuario cadastrarNovo(Usuario usuario) {
        this.usuarioDao.save(usuario);
        return usuario;
    }

    @Override
    public Usuario getUsuarioPorId(Long id) {
        return this.usuarioDao.findById(id);
    }

    @Override
    public Usuario getUsuarioPorEmail(String email) {
        return this.usuarioDao.findByEmail(email);
    }

    @Override
    public Usuario getUsuarioPorCpf(String cpf) {
        return this.usuarioDao.findByCpf(cpf);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void removerUsuario(Long id) {
        this.usuarioDao.delete(id);
    }
}
