package by.serhel.contentsgeneretor.creator.impl;

import by.serhel.contentsgeneretor.creator.MDContentsCreator;
import by.serhel.contentsgeneretor.entity.CustomNode;

import java.util.List;

public class MDContentsCreatorImpl implements MDContentsCreator {
    @Override
    public String create(List<CustomNode> nodes) {
        StringBuilder builder = new StringBuilder();
        getIndexed(nodes, 0, builder, 0);
        return builder.toString();
    }

    private int getIndexed(List<CustomNode> nodes, int index, StringBuilder builder, int tabCount){
        int count = 1;
        addTabs(builder, tabCount);
        CustomNode buff = nodes.get(index);
        builder.append(count + ". [" + buff.getName() + "](#" + buff.getReference() + ")\n");
        count++;
        int level = buff.getTitleLevel();
        for(index += 1; index < nodes.size() && level <= nodes.get(index).getTitleLevel(); index++){
            buff = nodes.get(index);
            if(level < buff.getTitleLevel()){
                index = getIndexed(nodes, index, builder, tabCount + 1) - 1;
            }
            else{
                addTabs(builder, tabCount);
                builder.append(count)
                        .append(". [")
                        .append(buff.getName())
                        .append("](#")
                        .append(buff.getReference())
                        .append(")\n");
                count++;
            }
        }
        return index;
    }

    private void addTabs(StringBuilder builder, int count){
        for(int i = 0; i < count; i++){
            builder.append("\t");
        }
    }
}
