package com.diacom.diacom.enums;

public enum HowManyTimes {
    onePerDay(0),
    twoPerDay(1),
    threePerDay(2),
    fourPerDay(3),
    fivePerDay(4);

    private int howManyTimes;

    HowManyTimes(int howManyTimes){
        this.howManyTimes = howManyTimes;
    }


}
