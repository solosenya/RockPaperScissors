package com.example.rockpaperscissors.models.MoveGenerator;

import com.example.rockpaperscissors.models.RPSlogic.RPSEnum;

import java.util.Random;

//Класс, единственной целью которого является псевдослучайная генерация значение из перечесления PRSEnum

public class MoveGenerator {
    public static RPSEnum generateOpponentsMove () {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0: return RPSEnum.ROCK;
            case 1: return RPSEnum.SCISSORS;
            case 2: return RPSEnum.PAPER;
        }

        throw new IllegalArgumentException();
    }
}
