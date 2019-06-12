package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;

import java.util.List;

public interface DirectorService {
    List<Paper> createPaperList(BaseBuilderService builder);
}
