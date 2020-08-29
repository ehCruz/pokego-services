package ehcruz.com.github.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "TB_POKEMON",
        uniqueConstraints = @UniqueConstraint(columnNames = "id_api_pokemon"))
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokemon")
    private Long id;

    @Column(name = "id_api_pokemon")
    @NotNull(message = "{pokemon.notblank}")
    private Long idApi;

    @Column(name = "name_pokemon")
    @NotBlank(message = "{pokemon.notblank}")
    private String name;

    @Column(name = "image_url_pokemon")
    @NotBlank(message = "{pokemon.notblank}")
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public Long getIdApi() {
        return idApi;
    }

    public void setIdApi(Long idApi) {
        this.idApi = idApi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
