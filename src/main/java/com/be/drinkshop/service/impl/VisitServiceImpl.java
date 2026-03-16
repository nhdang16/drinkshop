package com.be.drinkshop.service.impl;

import com.be.drinkshop.dto.StatisticDTO;
import com.be.drinkshop.repository.VisitRepository;
import com.be.drinkshop.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitRepository visitRepository;
    @Override
    public StatisticDTO getMonthlyVisitStat() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startThis = now.with(TemporalAdjusters.firstDayOfMonth()).toLocalDate().atStartOfDay();
        LocalDateTime startNext = startThis.plusMonths(1);
        LocalDateTime startLast = startThis.minusMonths(1);
        LocalDateTime endLast = startThis;

        long current = visitRepository.countByVisitedAtBetween(startThis, startNext);
        long previous = visitRepository.countByVisitedAtBetween(startLast, endLast);

        double changePercentage = 0;
        if (previous > 0) {
            changePercentage = ((current - previous) / (double) previous) * 100;
        }

        String changeString = String.format("%+.1f%%", changePercentage);
        boolean positive = changePercentage >= 0;
        return new StatisticDTO("Website Visit Counts", current, changeString, positive);
    }
}
