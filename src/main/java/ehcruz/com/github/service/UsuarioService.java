package ehcruz.com.github.service;

import ehcruz.com.github.domain.Pokemon;
import ehcruz.com.github.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario cadastrarNovo(Usuario usuario);

    Usuario getUsuarioPorId(Long id);

    Usuario getUsuarioPorEmail(String email);

    Usuario getUsuarioPorCpf(String cpf);

    Usuario atualizarUsuario(Usuario usuario);

    void removerUsuario(Long id);

    Usuario adicionarNovoPokemon(Long idUsuario, Long idPokemon);

    Usuario removerPokemon(Long idUsuario, Long idPokemon);

    Usuario getUsuarioLogin(String email, String cpf);

    List<Pokemon> pesquisaColecao(Long idUsuario, String termoPesquisa);
}
