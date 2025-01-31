package com.syfe.FinancialManagementProject.Controller;

import com.syfe.FinancialManagementProject.DTO.ReportDTO;
import com.syfe.FinancialManagementProject.Entity.ReportEntity;
import com.syfe.FinancialManagementProject.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/{year}")
    public ReportEntity generateYearlyReport(@PathVariable Integer year) throws Exception {
        return reportService.generateYearlyReport(year);
    }

    @GetMapping()
    public ReportEntity generateMonthlyReport(@RequestBody ReportDTO reportDTO) throws Exception {
        return reportService.generateMonthlyReport(reportDTO.getFromDate(), reportDTO.getUptoDate());
    }
}
