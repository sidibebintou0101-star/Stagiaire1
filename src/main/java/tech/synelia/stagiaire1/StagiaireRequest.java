package tech.synelia.stagiaire1;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StagiaireRequest(
        @NotBlank(message = "Le nom est obligatoire")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        String prenom,

        @NotBlank(message = "L'e-mail est obligatoire")
        @Email(message = "Adresse e-mail invalide")
        String email,

        @NotNull(message = "La formation est obligatoire")
        Long formationId
) {
}
