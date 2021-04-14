package by.serhel.contentsgeneretor.parser.impl;

import by.serhel.contentsgeneretor.entity.CustomNode;
import by.serhel.contentsgeneretor.parser.CustomParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MDTitleParser implements CustomParser {
    public static final int MAX_HASHES_IN_TITLE = 6;
    public static final String NOT_REFERENCE_SYMBOLS = "[^a-z\\d\\-_]";
    public static final String WHITESPACE_REGEX = "\\s";

    @Override
    public List<CustomNode> parse(Stream<String> lines) {
        List<CustomNode> nodes = lines.map(line -> {
            int level = getCalculateTitleLevel(line);
            String reference = toMDReference(line, level);
            String name = line.substring(level).trim();
            return new CustomNode(name, reference, level);
        })
                .collect(Collectors.toList());
        return nodes;
    }

    public String toMDReference(String title, int titleLevel){
        title = title.trim();
        String reference = new String(title.substring(titleLevel));
        reference = reference.trim();
        reference = reference.toLowerCase();
        reference = reference.replaceAll(WHITESPACE_REGEX, "-");
        reference = reference.replaceAll(NOT_REFERENCE_SYMBOLS, "");
        return reference;
    }

    public int getCalculateTitleLevel(String title){
        title = title.trim();
        int level = 1;
        for(int i = level; i < 6; i++){
            if(title.length() < i || title.charAt(i) != '#'){
                break;
            }
            level++;
        }
        return level;
    }
}
