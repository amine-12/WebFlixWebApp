package org.example.controller;
import java.util.List;

import org.example.DTO.FilmDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable int id) {
        FilmDTO film = new FilmDTO(
                "Forrest Gump",
                1994,
                "English",
                142,
                List.of("USA"),
                List.of("Drame", "Romance"),
                "Robert Zemeckis",
                List.of("Eric Roth"),
                List.of(
                        new FilmDTO.Acteur("Tom Hanks", "Forrest Gump"),
                        new FilmDTO.Acteur("Robin Wright", "Jenny Curran")
                ),
                "Forrest Gump, un homme simple d'esprit, traverse l'histoire américaine.",
                "https://example.com/forrest.jpg",
                List.of("https://www.youtube.com/watch?v=bLvqoHBptjg")
        );
        return ResponseEntity.ok(film);
    }
}


//@Path("/films")
//public class FilmController {
//
//    private FilmService filmService = new FilmService();
//
//
//
////    @GET
////    @Path("/{id}")
////    @Produces(MediaType.APPLICATION_JSON)
////    public Film getFilm(@PathParam("id") int id) {
////        return filmService.getFilmDetails(id);
////    }
//}
