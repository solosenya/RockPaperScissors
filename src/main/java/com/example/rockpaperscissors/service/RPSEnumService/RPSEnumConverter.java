package com.example.rockpaperscissors.service.RPSEnumService;

import com.example.rockpaperscissors.service.RPSEnumService.RPSEnum;

import java.util.Locale;

//Класс, призванный конвертировать значение перечисления в строку и обратно

public class RPSEnumConverter {

    //метод, конвертирующий строковое значение в соотвествующее значение перечисления,
    // если отформатировнная строка не подходит ни под одно из значений перечислений,
    // то возвращается null
    public static RPSEnum convertStringToEnum(String rpsEnumString) {
        switch (rpsEnumString
                .toLowerCase(Locale.ROOT)
                .trim()) {
            case "камень": return RPSEnum.ROCK;
            case "бумага": return RPSEnum.PAPER;
            case "ножницы": return RPSEnum.SCISSORS;
        }
        return null;
    }

    //метод, конвертирующий значение перечисления в строку
    public static String convertEnumToRusString(RPSEnum rpsEnum) {
        switch (rpsEnum) {
            case ROCK: return "Камень";
            case PAPER: return "Бумага";
            case SCISSORS: return "Ножницы";
        }
        throw new IllegalArgumentException();
    }
}
