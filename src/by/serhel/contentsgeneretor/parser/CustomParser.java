package by.serhel.contentsgeneretor.parser;

import by.serhel.contentsgeneretor.entity.CustomNode;

import java.util.List;
import java.util.stream.Stream;

public interface CustomParser {
    List<CustomNode> parse(Stream<String> lines);
}
