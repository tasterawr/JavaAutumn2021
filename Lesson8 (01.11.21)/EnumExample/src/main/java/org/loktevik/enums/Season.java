package org.loktevik.enums;

public enum Season {
    SPRING("тепло"),
    SUMMER("жарко"),
    AUTUMN("прохладно"),
    WINTER("холодно");

    private String description;

    Season(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
