package by.serhel.contentsgeneretor;

import by.serhel.contentsgeneretor.creator.MDContentsCreator;
import by.serhel.contentsgeneretor.creator.impl.MDContentsCreatorImpl;
import by.serhel.contentsgeneretor.exception.CustomFileException;
import by.serhel.contentsgeneretor.files.CustomFiles;
import by.serhel.contentsgeneretor.files.impl.CustomFilesImpl;
import by.serhel.contentsgeneretor.parser.CustomParser;
import by.serhel.contentsgeneretor.parser.impl.MDTitleParser;
import by.serhel.contentsgeneretor.validator.Validator;
import by.serhel.contentsgeneretor.entity.CustomNode;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        CustomParser parser = new MDTitleParser();
        MDContentsCreator creator = new MDContentsCreatorImpl();
        try{
            if(args.length < 1){
                throw new CustomFileException("Bad arguments! There is no arguments!");
            }
            CustomFiles reader = new CustomFilesImpl(args[0]);
            Stream<String> lines = reader.readToStream();
            lines = lines.filter(Validator::isTitle);
            List<CustomNode> list = parser.parse(lines);
            String str = creator.create(list);
            str = str + "\n" + reader.readString();
            reader.write(str);
            System.out.println(str);
        }
        catch (CustomFileException e){
            e.printStackTrace();
        }
    }
}
