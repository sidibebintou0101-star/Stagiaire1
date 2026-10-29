package tech.synelia.stagiaire1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class FormationIntrouvable extends RuntimeException {

        public FormationIntrouvable(String message) {
            super(message);
        }
    }


