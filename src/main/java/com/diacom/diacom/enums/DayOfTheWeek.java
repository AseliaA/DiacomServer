package com.diacom.diacom.enums;

public enum DayOfTheWeek {
    Monday(0),
    Tuesday(1),
    Wednesday(2),
    Thursday(3),
    Friday(4),
    Saturday(5),
    Sunday(6),
    EveryDay(7);

    private int dayNumber;

    DayOfTheWeek(int dayNumber){
        this.dayNumber = dayNumber;
    }
}
