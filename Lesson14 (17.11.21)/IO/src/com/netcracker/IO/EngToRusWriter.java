package com.netcracker.IO;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * Класс, который при записи заменяет английские буквы
 * на русские буквы аналогичного начертания,
 * либо оставляет английскую букву при отсутствии аналога.
 */
public class EngToRusWriter extends FilterWriter {
    protected EngToRusWriter(Writer out) {
        super(out);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(EngToRusTable.getSymbol(c));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < len; i++) {
            cbuf[i] = EngToRusTable.getSymbol(cbuf[i]);
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        StringBuilder newStr = new StringBuilder(str);
        for (int i = off; i < len; i++){
            newStr.insert(i, EngToRusTable.getSymbol(str.charAt(i)));
        }
        super.write(newStr.toString(), off, len);
    }
}
