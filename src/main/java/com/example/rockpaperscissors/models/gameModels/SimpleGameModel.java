package com.example.rockpaperscissors.models.gameModels;

import com.example.rockpaperscissors.models.MoveGenerator.MoveGenerator;
import com.example.rockpaperscissors.models.RPSlogic.RPSComparator;
import com.example.rockpaperscissors.models.RPSlogic.RPSEnum;
import com.example.rockpaperscissors.models.RPSlogic.RPSEnumConverter;

import java.util.ArrayList;

// Класс, реализующий логику "простой" игры

public class SimpleGameModel {

    // Число побед пользователя
    private static int userWins = 0;
    // Число побед компьютера
    private static int opponentsWins = 0;

    // Инкременторы и геттеры полей, описанных выше
    public static void incrementUsersWins() {
        SimpleGameModel.userWins++;
    }

    public static void incrementOpponentsWins() {
        SimpleGameModel.opponentsWins++;
    }

    public static int getOpponentsWins() {
        return opponentsWins;
    }

    public static int getUserWins() {
        return userWins;
    }

    // Метод, возвращающий сообщение о начале игры и возможных действиях игрока
    public static String startGame() {
        return "выберите вариант хода из 'камень', 'ножницы', 'бумага";
    }

    // Метод, определяющий победителя на основе RPSComparator'а и возвращающий результат "простой" игры
    public static ArrayList<String> setResultOfAGame(RPSEnum usersMove) {
        RPSEnum opponentsMove = MoveGenerator.generateOpponentsMove();

        ArrayList<String> result = new ArrayList<>();

        RPSComparator comparator = new RPSComparator(usersMove);

        if (comparator.compareTo(opponentsMove) > 0) {
            SimpleGameModel.incrementUsersWins();
            result.add("Вы победили!");
        } else if (comparator.compareTo(opponentsMove) < 0) {
            SimpleGameModel.incrementOpponentsWins();
            result.add("К сожалению, Вы прогирали");
        } else result.add("Ничья, требуется переигровка!");

        result.add("Ваш ход: " + RPSEnumConverter.convertEnumToRusString(usersMove));
        result.add("Ход оппонента: " + RPSEnumConverter.convertEnumToRusString(opponentsMove));

        return result;
    }
}
