package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;

import java.io.File;
import java.util.List;

public interface DOMParserService {
    List<Paper> parse(File file) throws ServiceException;
    List<Paper> parse(String fileName) throws ServiceException;
}
