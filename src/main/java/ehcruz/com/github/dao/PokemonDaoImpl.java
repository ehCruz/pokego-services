package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Pokemon;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonDaoImpl extends AbstractDao<Pokemon, Long> implements PokemonDao {
}
