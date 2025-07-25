package org.example.facade;

import org.example.DTO.AnalyticsFilterDTO;
import org.example.DTO.AnalyticsResultDTO;
import org.example.service.AnalyticsService;

public class AnalyticsFacade {
    private final AnalyticsService service = new AnalyticsService();

    public AnalyticsResultDTO countLocations(AnalyticsFilterDTO filter) {
        long cnt = service.countLocations(filter);
        return new AnalyticsResultDTO(cnt);
    }
}
