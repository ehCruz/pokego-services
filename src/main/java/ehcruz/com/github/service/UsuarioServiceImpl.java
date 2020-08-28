package ehcruz.com.github.service;

import ehcruz.com.github.dao.UsuarioDao;
import ehcruz.com.github.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario cadastrarNovo(Usuario usuario) {
        this.usuarioDao.save(usuario);
        return usuario;
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getUsuarioPorId(Long id) {
        return this.usuarioDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getUsuarioPorEmail(String email) {
        return this.usuarioDao.findByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getUsuarioPorCpf(String cpf) {
        return this.usuarioDao.findByCpf(cpf);
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        this.usuarioDao.update(usuario);
        return usuario;
    }

    @Override
    public void removerUsuario(Long id) {
        this.usuarioDao.delete(id);
    }
}
