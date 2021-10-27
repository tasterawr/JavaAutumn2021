package org.loktevik.exceptions;

public class Image {

    private int height;
    private int width;

    public Image() {}

    public Image(int height, int width) {
        if (height < 0){
            throw new InvalidImageProperty("Недопустимое значение высоты: " + height);
        }
        else if (width < 0){
            throw new InvalidImageProperty("Недопустимое значение ширины: " + width);
        }

        this.height = height;
        this.width = width;
    }

    public void reshape(int height, int width) {
        if (height < 0){
            throw new InvalidImageProperty("Недопустимое значение высоты: " + height);
        }
        else if (width < 0){
            throw new InvalidImageProperty("Недопустимое значение ширины: " + width);
        }

        this.height = height;
        this.width = width;
    }
}
