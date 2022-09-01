package com.example.rockpaperscissors.models.statisticsModel;

import com.example.rockpaperscissors.models.gameModels.SimpleGameModel;
import com.example.rockpaperscissors.models.gameModels.UpToThreeWinsGameModel;

import java.util.ArrayList;


// Класс, создающий сообщение, которое выводится в единственном методе StatisticsController,
// на основе результатов игр пользователя в каждый из вариантов игр
public class StatisticsModel {

    public static ArrayList<String> showStatistics() {
        ArrayList<String> statistics = new ArrayList<>();

        statistics.add("Число твоих побед в простой игре: " + SimpleGameModel.getUserWins());
        statistics.add("Число побед оппонента в простой игре: " + SimpleGameModel.getOpponentsWins());

        statistics.add("Число твоих побед в игре \"до трех\": " + UpToThreeWinsGameModel.getUsersWinsInUTTWGames());
        statistics.add("Число побед оппонента в игре \"до трех\": " + UpToThreeWinsGameModel.getOpponentsWinsInUTTWGames());

        return statistics;
    }
}
