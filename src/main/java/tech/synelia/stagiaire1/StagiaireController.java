package tech.synelia.stagiaire1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class StagiaireController {

    private final StagiaireService service;

    public StagiaireController(StagiaireService service) {
        this.service = service;
    }

    @GetMapping("/api/stagiaires")
    public List<StagiaireResponse> lister() {
        return service.recupererStagiaire();
    }

    @GetMapping("/api/stagiaires/{id}")
    public StagiaireResponse stagiaire(@PathVariable long id) {
        return service.trouverStagiaire(id);
    }

    @PostMapping("/api/stagiaires")
    public ResponseEntity<StagiaireResponse> creer(
            @Valid @RequestBody StagiaireRequest request) {

        StagiaireResponse cree = service.creerStagiaire(request);

        return ResponseEntity
                .created(URI.create("/api/stagiaires/" + cree.id()))
                .body(cree);
    }
}
