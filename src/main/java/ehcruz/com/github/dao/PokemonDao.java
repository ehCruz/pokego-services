package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Pokemon;

import java.util.List;

public interface PokemonDao {

    void save(Pokemon usuario);

    Pokemon findById(Long id);

    List<Pokemon> findAll();
}
