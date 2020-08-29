package ehcruz.com.github.service;

import ehcruz.com.github.domain.Usuario;

public interface UsuarioService {

    Usuario cadastrarNovo(Usuario usuario);

    Usuario getUsuarioPorId(Long id);

    Usuario getUsuarioPorEmail(String email);

    Usuario getUsuarioPorCpf(String cpf);

    Usuario atualizarUsuario(Usuario usuario);

    void removerUsuario(Long id);

    Usuario adicionarNovoPokemon(Long idUsuario, Long idPokemon);

    Usuario removerPokemon(Long idUsuario, Long idPokemon);

}
