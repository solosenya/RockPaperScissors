package com.example.rockpaperscissors.controller;

import com.example.rockpaperscissors.service.RPSEnumService.RPSEnum;
import com.example.rockpaperscissors.service.RPSEnumService.RPSEnumConverter;
import com.example.rockpaperscissors.model.gameModels.UpToThreeWinsGameModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Класс представляет собой контроллер "игры до трех побед"
// Доступные методы: Get http://localhost:8080/rockPaperScissors/upToThreeWinsGame/start
// Здесь происходит запуск игры и пользователь оповещается об этом;
//
// Get http://localhost:8080/rockPaperScissors/upToThreeWinsGame/finishGame
// Здесь происходит досрочное прекращение игры, пользователь оповещается об этом,
// никто не назначается победителем;
//
// Get http://localhost:8080/rockPaperScissors/upToThreeWinsGame/upToThreeWinsGameProcess
// Здесь начинается игра, пользователя оповещают о возможных действиях;
//
//
// Post http://localhost:8080/rockPaperScissors/upToThreeWinsGame/upToThreeWinsGameProcess
// Здесь пользователь может отправить запрос с параметром usersMoveString,
// в котором указывает выбранное им действие, в ответ получает результат,
// в котором ему сообщается о результате простой игры: победа, ничья, поражение и сделланные ходы обеими сторонами.
// Помимо этого выводится текущий счет в игре или информация о победе или поражении.
// В случае, если пользователь ввел значение,
// не соответсвующее ни одному из возможных (камень, ножницы, бумага),
// то он получает сообщение с просьбой ввести корректное действие и ошибку 406(Not Acceptable)

@RestController
@RequestMapping("/rockPaperScissors/upToThreeWinsGame")
public class UpToThreeWinsGameController {

    @GetMapping("/start")
    public ResponseEntity<String> startUpToThreeWinsGame() {
        return new ResponseEntity<>(UpToThreeWinsGameModel.startGame(), HttpStatus.OK);
    }

    @GetMapping("/finishGame")
    public ResponseEntity<String> finishGameAheadOfTime() {
        return new ResponseEntity<>(UpToThreeWinsGameModel.finishGameAheadOfTime(), HttpStatus.OK);
    }

    @GetMapping("/upToThreeWinsGameProcess")
    public ResponseEntity<String> upToThreeWinsGameProcess() {
        return new ResponseEntity<>("выберите вариант хода из 'камень', 'ножницы', 'бумага", HttpStatus.OK);
    }

    @PostMapping("/upToThreeWinsGameProcess")
    public ResponseEntity<List<String>> upToThreeWinsGameProcessResult(@RequestParam String usersMoveString) {
        RPSEnum usersMove = RPSEnumConverter.convertStringToEnum(usersMoveString);

        if (usersMove == null) return new ResponseEntity<>(
                List.of("Некорректное значение для действия! Выберите подходящее из вариантов: 'камень', 'ножницы', 'бумага"),
                HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(UpToThreeWinsGameModel.setResultsOfASingleGame(usersMove), HttpStatus.OK);
    }
}
