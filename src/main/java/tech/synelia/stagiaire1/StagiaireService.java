package tech.synelia.stagiaire1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StagiaireService {

    private final List<StagiaireResponse> stagiaires = new ArrayList<>(
            List.of(
                    new StagiaireResponse(1L, "Sidibe", "Bintou", 14),
                    new StagiaireResponse(2L, "Toure", "Bakary", 15)
            )
    );

    private final Map<Long, String> formations = Map.of(
            1L, "Java",
            2L, "Spring Boot"
    );

    public List<StagiaireResponse> recupererStagiaire() {
        return stagiaires;
    }

    public StagiaireResponse trouverStagiaire(long id) {
        return stagiaires.stream()
                .filter(s -> s.id() == id)
                .findFirst()
                .orElse(null);
    }

    public StagiaireResponse creerStagiaire(StagiaireRequest request) {

        if (!formations.containsKey(request.formationId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Formation introuvable : " + request.formationId()
            );
        }

        long id = stagiaires.stream()
                .mapToLong(StagiaireResponse::id)
                .max()
                .orElse(0) + 1;

        StagiaireResponse cree = new StagiaireResponse(
                id,
                request.nom(),
                request.prenom(),
                0
        );

        stagiaires.add(cree);

        return cree;
    }
}
