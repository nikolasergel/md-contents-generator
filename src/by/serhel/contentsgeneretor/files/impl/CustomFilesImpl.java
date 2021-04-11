package by.serhel.contentsgeneretor.files.impl;

import by.serhel.contentsgeneretor.exception.CustomFileException;
import by.serhel.contentsgeneretor.files.CustomFiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CustomFilesImpl implements CustomFiles {
    private Path path;

    public CustomFilesImpl(String filePath) throws CustomFileException {
        this.path = Paths.get(filePath);
        if(!Files.exists(path)){
            throw new CustomFileException("File path is incorrect or equals null!");
        }
    }

    public Path getPath() {
        return path;
    }

    @Override
    public Stream<String> readToStream() throws CustomFileException {
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            throw new CustomFileException(e.getMessage());
        }
        return lines;
    }

    public String readString() throws CustomFileException {
        String str = "";
        try {
            str = Files.readString(path);
        } catch (IOException e) {
            throw new CustomFileException(e.getMessage());
        }
        return str;
    }

    @Override
    public void write(String text) throws CustomFileException {
        try {
            Files.write(path, text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new CustomFileException(e.getMessage());
        }
    }
}
