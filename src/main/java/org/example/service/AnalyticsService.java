package org.example.service;

import org.example.dao.AnalyticsDAO;
import org.example.DTO.AnalyticsFilterDTO;

public class AnalyticsService {
    private final AnalyticsDAO dao = new AnalyticsDAO();

    public long countLocations(AnalyticsFilterDTO f) {
        return dao.countLocations(
                f.getGroupeAge(),
                f.getProvince(),
                f.getJourSemaine(),
                f.getMois()
        );
    }
}
