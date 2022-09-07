package com.example.rockpaperscissors.model.gameModels;

import com.example.rockpaperscissors.service.MoveGeneratorService.MoveGenerator;
import com.example.rockpaperscissors.service.RPSEnumService.RPSEnumComparator;
import com.example.rockpaperscissors.service.RPSEnumService.RPSEnum;
import com.example.rockpaperscissors.service.RPSEnumService.RPSEnumConverter;

import java.util.ArrayList;

// Класс, реализующий логику игры "до трех побед"

public class UpToThreeWinsGameModel {

    // Число побед пользователя в текущей игре
    public static int usersWinsInASingleGame = 0;
    // Число побед компьютера в текущей игре
    public static int opponentsWinsInASingleGame = 0;

    // Число побед пользователя в играх "до трех побед"
    public static int usersWinsInUTTWGames = 0;
    // Число побед компьютера в играх "до трех побед"
    public static int opponentsWinsInUTTWGames = 0;

    // Метод, задающий стартовые(нулевые) значения числам побед компьютера и пользователя в текущей игре,
    // а также возвращющий оповещение о старте игры
    public static String startGame() {
        UpToThreeWinsGameModel.setUsersWinsInASingleGame(0);
        UpToThreeWinsGameModel.setOpponentsWinsInASingleGame(0);
        return "игра начата";
    }

    // Метод, досрочно завершающий игру и сбрасывающий числв побед пользователя и компьютера в текущей игре
    public static String finishGameAheadOfTime() {
        UpToThreeWinsGameModel.resetResultOfASingleGame();
        return "игра завершена досрочно";
    }

    // Метод, определяющий победителя на основе RPSComparator'а и возвращающий результат текщего действия в игре
    // или оповещающий о победе одной из сторон (достижения трех текущих побед)
    public static ArrayList<String> setResultsOfASingleGame(RPSEnum usersMove) {
        RPSEnum opponentsMove = MoveGenerator.generateOpponentsMove();

        ArrayList<String> result = new ArrayList<>();

        result.add("Ваш ход: " + RPSEnumConverter.convertEnumToRusString(usersMove));
        result.add("Ход оппонента: " + RPSEnumConverter.convertEnumToRusString(opponentsMove));

        if (new RPSEnumComparator(usersMove).compareTo(opponentsMove) == 0) {
            result.add("Ничья, требуется переигровка!");
            result.add("Количество ваших побед в игре \"до трех\": "
                    + UpToThreeWinsGameModel.getUsersWinsInASingleGame());
            result.add("Количество побед оппонента в игре \"до трех\": "
                    + UpToThreeWinsGameModel.getOpponentsWinsInASingleGame());
        }

        else if (new RPSEnumComparator(usersMove).compareTo(opponentsMove) > 0) {
            UpToThreeWinsGameModel.incrementUsersWinsInASingleGame();
            if (UpToThreeWinsGameModel.getUsersWinsInASingleGame() == 3) {
                UpToThreeWinsGameModel.resetResultOfASingleGame();

                UpToThreeWinsGameModel.incrementUsersWinsInUTTWGames();

                result.add("Вы одержали победу во всей игре!");
            } else {
                result.add("Количество ваших побед в игре \"до трех\": "
                        + UpToThreeWinsGameModel.getUsersWinsInASingleGame());
                result.add("Количество побед оппонента в игре \"до трех\": "
                        + UpToThreeWinsGameModel.getOpponentsWinsInASingleGame());
            }
        }
        else {
            UpToThreeWinsGameModel.incrementOpponentsWinsInASingleGame();
            if (UpToThreeWinsGameModel.getOpponentsWinsInASingleGame() == 3) {
                UpToThreeWinsGameModel.resetResultOfASingleGame();

                UpToThreeWinsGameModel.incrementOpponentsWinsInUTTWGames();

                result.add("К сожалению, Вы прогирали во всей игре");
            } else {
                result.add("Количество ваших побед в игре \"до трех\": "
                        + UpToThreeWinsGameModel.getUsersWinsInASingleGame());
                result.add("Количество побед оппонента в игре \"до трех\": "
                        + UpToThreeWinsGameModel.getOpponentsWinsInASingleGame());
            }
        }

        return result;
    }

    // Метод, сбрасывающий числа побед пользователя и компьютера в текущей игре (
    // досрочно завершает игру без определения победителя)
    public static void resetResultOfASingleGame() {
        UpToThreeWinsGameModel.setUsersWinsInASingleGame(0);
        UpToThreeWinsGameModel.setOpponentsWinsInASingleGame(0);
    }

    // Геттеры, инкременторы и сеттеры
    public static int getOpponentsWinsInASingleGame() {
        return opponentsWinsInASingleGame;
    }

    public static int getUsersWinsInASingleGame() {
        return usersWinsInASingleGame;
    }

    public static int getUsersWinsInUTTWGames() {
        return usersWinsInUTTWGames;
    }

    public static int getOpponentsWinsInUTTWGames() {
        return opponentsWinsInUTTWGames;
    }

    public static void incrementOpponentsWinsInASingleGame() {
        UpToThreeWinsGameModel.opponentsWinsInASingleGame++;
    }

    public static void incrementOpponentsWinsInUTTWGames() {
        UpToThreeWinsGameModel.opponentsWinsInUTTWGames++;
    }

    public static void incrementUsersWinsInASingleGame() {
        UpToThreeWinsGameModel.usersWinsInASingleGame++;
    }

    public static void incrementUsersWinsInUTTWGames() {
        UpToThreeWinsGameModel.usersWinsInUTTWGames++;
    }

    public static void setUsersWinsInASingleGame(int usersWinsInASingleGame) {
        UpToThreeWinsGameModel.usersWinsInASingleGame = usersWinsInASingleGame;
    }

    public static void setOpponentsWinsInASingleGame(int opponentsWinsInASingleGame) {
        UpToThreeWinsGameModel.opponentsWinsInASingleGame = opponentsWinsInASingleGame;
    }
}
