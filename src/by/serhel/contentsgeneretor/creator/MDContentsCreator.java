package by.serhel.contentsgeneretor.creator;

import by.serhel.contentsgeneretor.entity.CustomNode;

import java.util.List;

public interface MDContentsCreator {
    String create(List<CustomNode> nodes);
}
