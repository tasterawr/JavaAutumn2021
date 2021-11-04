package org.loktevik;

import org.loktevik.enums.Month;
import org.loktevik.enums.Season;

import java.util.EnumMap;
import java.util.concurrent.Callable;

public enum SeasonService {
    INSTANCE;

    private EnumMap<Month, Callable<Season>> enumMap;

    SeasonService(){
        enumMap = new EnumMap<>(Month.class);

        for (Month m : Month.values()){
            if (m.ordinal() < 3){
                enumMap.put(m, () -> Season.WINTER);
            }
            else if (3 <= m.ordinal() && m.ordinal() < 6){
                enumMap.put(m, () -> Season.SPRING);
            }
            else if (6 <= m.ordinal() && m.ordinal() < 9){
                enumMap.put(m, () -> Season.SUMMER);
            }
            else if (m.ordinal() >= 9){
                enumMap.put(m, () -> Season.AUTUMN);
            }
        }
    }

    void showSeason(Month month) throws Exception {
        Season season = enumMap.get(month).call();
        System.out.printf("Время года: %s, Описание: %s \n", season.name(), season.getDescription());
    }
}
