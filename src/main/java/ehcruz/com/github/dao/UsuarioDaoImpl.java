package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Pokemon;
import ehcruz.com.github.domain.Usuario;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

    @Override
    public Usuario findByEmail(String email) {
        String query = "SELECT u FROM Usuario u WHERE u.email LIKE :email";
        return this.getEntityManager().createQuery(query, Usuario.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public Usuario findByCpf(String cpf) {
        String query = "SELECT u FROM Usuario u WHERE u.cpf LIKE :cpf";
        return this.getEntityManager().createQuery(query, Usuario.class)
                .setParameter("cpf", cpf).getSingleResult();
    }

    @Override
    public Usuario findByEmailAndCpf(String email, String cpf) {
        String query = "SELECT u FROM Usuario u WHERE (u.email LIKE :email) AND (u.cpf LIKE :cpf)";
        Usuario usuario = null;
        try {
            usuario = this.getEntityManager().createQuery(query, Usuario.class)
                    .setParameter("email", email)
                    .setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException e) {
            // nada a fazer
        }
        return usuario;
    }

    @Override
    public List<Pokemon> searchPokemonByTerm(Long id, String term) {
        List<Pokemon> pokemons = new ArrayList<>();
        String query = "SELECT DISTINCT p FROM Usuario u " +
                "JOIN u.pokemons p "+
                "WHERE (u.id = :id) " +
                "AND UPPER(p.name) LIKE UPPER(CONCAT('%', :term, '%'))";
        try {
            pokemons = this.getEntityManager().createQuery(query)
                    .setParameter("id", id)
                    .setParameter("term", term)
                    .getResultList();
        } catch (NoResultException e) {

        }
        return pokemons;
    }
}
