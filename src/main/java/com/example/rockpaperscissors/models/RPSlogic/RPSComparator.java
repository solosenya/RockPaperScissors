package com.example.rockpaperscissors.models.RPSlogic;


//Класс, предоставляющий сравнение двух значений перечисления PRSEnum
public class RPSComparator implements Comparable<RPSEnum> {

    private RPSEnum o;

    public RPSComparator(RPSEnum o) {
        this.o = o;
    }

    @Override
    public int compareTo(RPSEnum o) {
        if (this.o.equals(o)) {
            return 0;
        }

        if (this.o.equals(RPSEnum.ROCK)) {
            switch (o) {
                case SCISSORS:
                    return 1;

                case PAPER:
                    return -1;
            }
        }

        if (this.o.equals(RPSEnum.SCISSORS)) {
            switch (o) {
                case ROCK:
                    return -1;

                case PAPER:
                    return 1;
            }
        }

        if (this.o.equals(RPSEnum.PAPER)) {
            switch (o) {
                case ROCK:
                    return 1;

                case SCISSORS:
                    return -1;
            }
        }

        throw new IllegalArgumentException();
    }
}
