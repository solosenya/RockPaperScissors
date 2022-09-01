package com.example.rockpaperscissors.controllers;

import com.example.rockpaperscissors.models.statisticsModel.StatisticsModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Класс представляет собой контроллер, ответсвенный за предоставление статистики
// Доступные методы: Get http://localhost:8080/rockPaperScissors/statistics
// Здесь выводится статистика о всех играх пользователя, как "простых", так и "до трех побед"

@RestController
@RequestMapping("/rockPaperScissors/statistics")
public class StatisticsController {

    @GetMapping
    public ResponseEntity<List<String>> getStatistics() {
        return new ResponseEntity<>(StatisticsModel.showStatistics(), HttpStatus.OK);
    }
}
