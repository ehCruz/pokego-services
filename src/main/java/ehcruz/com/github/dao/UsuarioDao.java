package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Pokemon;
import ehcruz.com.github.domain.Usuario;

import java.util.List;

public interface UsuarioDao {

    void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Long id);

    Usuario findById(Long id);

    List<Usuario> findAll();

    Usuario findByEmail(String email);

    Usuario findByCpf(String cpf);

    Usuario findByEmailAndCpf(String email, String cpf);

    List<Pokemon> searchPokemonByTerm(Long id, String term);
}
