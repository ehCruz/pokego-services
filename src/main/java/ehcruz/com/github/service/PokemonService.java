package ehcruz.com.github.service;

import ehcruz.com.github.domain.Pokemon;

public interface PokemonService {

    Pokemon cadastrar(Pokemon pokemon);

    Pokemon getPokemonPorId(Long id);
}
