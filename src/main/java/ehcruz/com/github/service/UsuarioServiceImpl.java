package ehcruz.com.github.service;

import ehcruz.com.github.dao.UsuarioDao;
import ehcruz.com.github.domain.Pokemon;
import ehcruz.com.github.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final PokemonService pokemonService;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao, PokemonService pokemonService) {
        this.usuarioDao = usuarioDao;
        this.pokemonService = pokemonService;
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

    @Override
    public Usuario adicionarNovoPokemon(Long idUsuario, Long idPokemon) {
        Usuario usuario = this.usuarioDao.findById(idUsuario);
        Pokemon pokemon = this.pokemonService.getPokemonPorId(idPokemon);
        usuario.adicionarNovoPokemon(pokemon);
        this.usuarioDao.update(usuario);
        return usuario;
    }

    @Override
    public Usuario removerPokemon(Long idUsuario, Long idPokemon) {
        Usuario usuario = this.usuarioDao.findById(idUsuario);
        Pokemon pokemon = this.pokemonService.getPokemonPorId(idPokemon);
        usuario.removerPokemon(pokemon);
        this.usuarioDao.update(usuario);
        return usuario;
    }

    @Override
    public Usuario getUsuarioLogin(String email, String cpf) {
        return this.usuarioDao.findByEmailAndCpf(email, cpf);
    }
}
