package ehcruz.com.github.domain;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioLogin {

    @NotBlank(message = "{validacao.notblank}")
    @Email(message = "{email.invalido}")
    private String email;

    @CPF(message = "{cpf.invalido}")
    @NotBlank(message = "{validacao.notblank}")
    private String cpf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
