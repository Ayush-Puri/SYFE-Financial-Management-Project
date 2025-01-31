package com.syfe.FinancialManagementProject.Service;

import com.syfe.FinancialManagementProject.DTO.TransactionReturnDTO;
import com.syfe.FinancialManagementProject.DTO.TransactionType;
import com.syfe.FinancialManagementProject.DTO.UserReadDTO;
import com.syfe.FinancialManagementProject.Entity.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Hashtable;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    public ReportEntity generateYearlyReport(Integer Year) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserReadDTO user = userService.findUser();
        int lastDayofYear =  Year%4==0 ? 366:365;
        List<TransactionReturnDTO> list = transactionService.findAllTransactionsByUser().stream()
                .filter(e -> e.getDateTime().getYear() == Year)
                .toList();

        if(list.isEmpty()){
            throw new Exception("No transactions Recorded in the Year : "+Year);
        }

        Hashtable<String, Double> categoryWiseSpending = new Hashtable<>();
        user.getCategory().stream().forEach(e -> categoryWiseSpending.put(e, 0.0));

        Double income = 0.0;
        Double expenses = 0.0;
        Double savings = 0.0;

        for(TransactionReturnDTO transaction : list){
            if(transaction.getType().equals(TransactionType.Income)){
                income+= transaction.getAmount();
            }
            if(transaction.getType().equals(TransactionType.Expense)){
                expenses+= transaction.getAmount();
            }
            if(transaction.getType().equals(TransactionType.Saving)){
                savings+= transaction.getAmount();
            }
            categoryWiseSpending.put(transaction.getCategory(),
                    categoryWiseSpending.get(transaction.getCategory())
                            + transaction.getAmount());

        }

        return ReportEntity.builder()
                .Expense(expenses)
                .Income(income)
                .Saving(savings)
                .transactionList(list)
                .categoryWiseSpending(categoryWiseSpending)
                .fromDate(LocalDate.ofYearDay(Year, 1))
                .uptoDate(LocalDate.ofYearDay(Year, lastDayofYear))
                .username(username)
                .build();
    }

    public ReportEntity generateMonthlyReport(LocalDate fromDate, LocalDate uptoDate) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserReadDTO user = userService.findUser();
        List<TransactionReturnDTO> list = transactionService.findAllTransactionsByUser().stream()
                .filter(e -> e.getDateTime().isAfter(fromDate.atStartOfDay()))
                .filter(e -> e.getDateTime().isBefore(uptoDate.atTime(LocalTime.MAX)))
                .toList();

        if(list.isEmpty()){
            throw new Exception("No transactions Recorded in the given Period from : "+fromDate+" to : "+uptoDate);
        }

        Hashtable<String, Double> categoryWiseSpending = new Hashtable<>();
        user.getCategory().stream().forEach(e -> categoryWiseSpending.put(e, 0.0));

        Double income = 0.0;
        Double expenses = 0.0;
        Double savings = 0.0;

        for(TransactionReturnDTO transaction : list){
            if(transaction.getType().equals(TransactionType.Income)){
                income+= transaction.getAmount();
            }
            if(transaction.getType().equals(TransactionType.Expense)){
                expenses+= transaction.getAmount();
            }
            if(transaction.getType().equals(TransactionType.Saving)){
                savings+= transaction.getAmount();
            }
            categoryWiseSpending.put(transaction.getCategory(),
                    categoryWiseSpending.get(transaction.getCategory())
                            + transaction.getAmount());

        }

        return ReportEntity.builder()
                .Expense(expenses)
                .Income(income)
                .Saving(savings)
                .transactionList(list)
                .categoryWiseSpending(categoryWiseSpending)
                .fromDate(fromDate)
                .uptoDate(uptoDate)
                .username(username)
                .build();
    }


}
