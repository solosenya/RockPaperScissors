package com.example.rockpaperscissors.controllers;

import com.example.rockpaperscissors.models.RPSlogic.RPSEnumConverter;
import com.example.rockpaperscissors.models.RPSlogic.RPSEnum;
import com.example.rockpaperscissors.models.gameModels.SimpleGameModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Класс представляет собой контроллер "простой игры"
// Доступные методы: Get http://localhost:8080/rockPaperScissors/simpleGame/simpleGameProcess
// Здесь происходит запуск игры и пользователь получает список значений (камень, ножницы, бумага),
// доступных для действия в игре;
//
// Post http://localhost:8080/rockPaperScissors/simpleGame/simpleGameProcess
// Здесь пользователь может отправить запрос с параметром usersMoveString,
// в котором указывает выбранное им действие, в ответ получает результат,
// в котором ему сообщается о результате простой игры: победа, ничья, поражение и сделланные ходы обеими сторонами.
// В случае, если пользователь ввел значение,
// не соответсвующее ни одному из возможных (камень, ножницы, бумага),
// то он получает сообщение с просьбой ввести корректное действие и ошибку 406(Not Acceptable)

@RestController
@RequestMapping("/rockPaperScissors/simpleGame")
public class SimpleGameController {

    @GetMapping("/simpleGameProcess")
    public ResponseEntity<String> simpleGameProcess() {
        return new ResponseEntity<>(SimpleGameModel.startGame(), HttpStatus.OK);
    }

    @PostMapping("/simpleGameProcess")
    public ResponseEntity<List<String>> simpleGameProcessResponse(@RequestParam String usersMoveString) {
        RPSEnum usersMove = RPSEnumConverter.convertStringToEnum(usersMoveString);

        if (usersMove == null) return new ResponseEntity<>(
                List.of("Некорректное значение для действия! Выберите подходящее из вариантов: 'камень', 'ножницы', 'бумага"),
                HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(SimpleGameModel.setResultOfAGame(usersMove), HttpStatus.OK);
    }
}
