package ehcruz.com.github.domain;


import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "cpf_usuario")
    @NotBlank(message = "{validacao.notblank}")
    @CPF(message = "{cpf.invalido}")
    private String cpf;

    @Column(name = "nome_usuario")
    @NotBlank(message = "{validacao.notblank}")
    @Pattern(regexp = "^[a-zA-Z]{3,}(?: [a-zA-Z]+){0,2}$", message = "{nome.invalido}")
    private String nome;

    @Column(name = "telefone_usuario")
    @NotBlank(message = "{validacao.notblank}")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "{telefone.invalido}")
    private String telefone;

    @Column(name = "email_usuario")
    @NotBlank(message = "{validacao.notblank}")
    @Email(message = "{email.invalido}")
    private String email;

    @Column(name = "dt_cadastro_usuario")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToMany
    @JoinTable(name = "TB_USUARIO_HAS_POKEMON",
            joinColumns = {@JoinColumn(name = "fk_id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "fk_id_pokemon")})
    private List<Pokemon> pokemons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
