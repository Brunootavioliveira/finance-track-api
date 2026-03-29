package br.com.brunootavio.finance_track.controller;

import br.com.brunootavio.finance_track.dto.DashboardResponseDTO;
import br.com.brunootavio.finance_track.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    @ResponseStatus(HttpStatus.OK)
    public DashboardResponseDTO getDashboard() {
        return dashboardService.getDashboard();
    }
}
