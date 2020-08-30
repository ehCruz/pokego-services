package ehcruz.com.github.web;

import ehcruz.com.github.domain.Pokemon;
import ehcruz.com.github.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "pokemon")
public class PokemonController extends ApplicationController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping(value = "cadastrar")
    public ResponseEntity<Pokemon> cadastrarPokemon(@Valid @RequestBody Pokemon pokemon) {
        Pokemon p = this.pokemonService.cadastrar(pokemon);
        return ResponseEntity.ok(p);
    }

    @GetMapping(value = "by/id/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") Long id) {
        Pokemon p = this.pokemonService.getPokemonPorId(id);
        return ResponseEntity.ok(p);
    }

    @GetMapping(value = "by/idApi/{id}")
    public ResponseEntity<?> getPokemonByIdApi(@PathVariable("id") Long id) {
        Pokemon pokemon = this.pokemonService.getPokemonPorIdApi(id);
        if (pokemon == null) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Pokemon informado não está cadastro na base.");
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(pokemon);
    }
}
