package ehcruz.com.github.service;

import ehcruz.com.github.dao.PokemonDao;
import ehcruz.com.github.domain.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
public class PokemonServiceImpl implements PokemonService {

    private final PokemonDao pokemonDao;

    @Autowired
    public PokemonServiceImpl(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @Override
    public Pokemon cadastrar(Pokemon pokemon) {
        this.pokemonDao.save(pokemon);
        return pokemon;
    }

    @Override
    public Pokemon getPokemonPorId(Long id) {
        return this.pokemonDao.findById(id);
    }

    @Override
    public Pokemon getPokemonPorIdApi(Long id) {
        return this.pokemonDao.findByIdApi(id);
    }
}
