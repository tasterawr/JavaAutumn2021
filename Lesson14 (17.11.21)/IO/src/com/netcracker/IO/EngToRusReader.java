package com.netcracker.IO;

import java.io.*;


/**
 * Класс, который при чтении заменяет английские буквы
 * на русские буквы аналогичного начертания,
 * либо оставляет английскую букву при отсутствии аналога.
 */
public class EngToRusReader extends FilterReader {
    protected EngToRusReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int result = in.read();

        return EngToRusTable.getSymbol(result);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int countOfSymbols = in.read(cbuf, off, len);
        for (int i = off; i < countOfSymbols + off; i++) {
            cbuf[i] = EngToRusTable.getSymbol(cbuf[i]);
        }
        return countOfSymbols;
    }
}
