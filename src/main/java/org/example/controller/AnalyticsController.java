package org.example.controller;

import org.example.DTO.AnalyticsFilterDTO;
import org.example.DTO.AnalyticsResultDTO;
import org.example.facade.AnalyticsFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsFacade facade = new AnalyticsFacade();

    @GetMapping("/locations")
    public ResponseEntity<AnalyticsResultDTO> countLocations(
            @RequestParam(required = false) String groupeAge,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String jourSemaine,
            @RequestParam(required = false) String mois
    ) {
        AnalyticsFilterDTO filter = new AnalyticsFilterDTO();
        filter.setGroupeAge(groupeAge);
        filter.setProvince(province);
        filter.setJourSemaine(jourSemaine);
        filter.setMois(mois);

        AnalyticsResultDTO result = facade.countLocations(filter);
        return ResponseEntity.ok(result);
    }
}
