package by.serhel.contentsgeneretor.files;

import by.serhel.contentsgeneretor.exception.CustomFileException;

import java.util.stream.Stream;

public interface CustomFiles {
    Stream<String> readToStream() throws CustomFileException;
    String readString() throws CustomFileException;
    void write(String text) throws CustomFileException;
}
