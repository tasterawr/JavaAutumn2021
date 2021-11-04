package org.loktevik;

import org.loktevik.enums.Month;

public class Main {
    public static void main(String[] args) throws Exception{
        SeasonService seasonService = SeasonService.INSTANCE;

        seasonService.showSeason(Month.APRIL);
        seasonService.showSeason(Month.DECEMBER);
        seasonService.showSeason(Month.AUGUST);
        seasonService.showSeason(Month.NOVEMBER);
    }
}
