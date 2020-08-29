package ehcruz.com.github.dao;

import ehcruz.com.github.domain.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

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
}
