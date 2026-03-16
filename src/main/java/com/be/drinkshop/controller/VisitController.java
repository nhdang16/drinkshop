package com.be.drinkshop.controller;

import com.be.drinkshop.model.Visit;
import com.be.drinkshop.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/visits")
public class VisitController {
    @Autowired
    private VisitRepository visitRepository;

    @PostMapping
    public ResponseEntity<Void> recordVisit() {
        visitRepository.save(new Visit(LocalDateTime.now()));
        return ResponseEntity.ok().build();
    }
}
