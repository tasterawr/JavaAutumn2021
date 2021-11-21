package com.netcracker.IO;

import java.io.*;
import java.util.Arrays;

public class UpperCaseDecorator extends FilterInputStream {

    public UpperCaseDecorator(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        int result = in.read();
        return result == -1 ? result : (int) Character.toUpperCase((char) result);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int countOfBytes = in.read(b, off, len);
        for (int i = off; i < countOfBytes + off; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return countOfBytes;
    }

    public static void main(String[] args) throws IOException {
        UpperCaseDecorator upperCaseDecorator =
                new UpperCaseDecorator(
                        new FileInputStream(".\\resources\\file.txt")
                );

        byte[] mas = new byte[upperCaseDecorator.available()];
        int read = upperCaseDecorator.read(mas, 0, upperCaseDecorator.available());
        System.out.println(read);
        System.out.println(new String(mas));
    }
}
