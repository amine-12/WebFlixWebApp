package org.example.controller;

import org.example.DTO.CredentialsDTO;
import org.example.DTO.PersonneDTO;
import org.example.facade.FilmSystemFacade;
import org.example.model.Personne;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final FilmSystemFacade facade = new FilmSystemFacade();

    @PostMapping("/login")
    public ResponseEntity<Personne> login(@RequestBody CredentialsDTO creds) {
        Personne user = facade.login(creds.getEmail(), creds.getMotDePasse());
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(user);
    }

//    @PostMapping("/register")
//    public ResponseEntity<PersonneDTO> register(
//            @RequestParam String role,
//            @RequestBody CredentialsDTO creds) {
//        try {
//            PersonneDTO user = facade.register(creds.getEmail(), creds.getMotDePasse(), role);
//            return ResponseEntity.ok(user);
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
}
