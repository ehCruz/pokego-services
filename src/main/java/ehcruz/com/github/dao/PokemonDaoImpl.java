package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Pokemon;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class PokemonDaoImpl extends AbstractDao<Pokemon, Long> implements PokemonDao {

    @Override
    public Pokemon findByIdApi(Long id) {
        String query = "SELECT p FROM Pokemon p WHERE p.idApi = :id";
        Pokemon p = null;
        try {
            p = this.getEntityManager().createQuery(query, Pokemon.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            // Nada a fazer
        }
        return p;
    }

}
