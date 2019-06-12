package by.epam.xmlparser.service.impl;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.service.BaseBuilderService;
import by.epam.xmlparser.service.DirectorService;

import java.util.List;

public class DirectorServiceImpl implements DirectorService {
    public List<Paper> createPaperList(BaseBuilderService builder) {
        builder.buildID();
        builder.buildType();
        builder.buildMonthly();
        builder.buildColor();
        builder.buildTitle();
        builder.buildVolume();
        builder.buildGlossy();
        builder.buildSubscriptionIndex();
        return builder.getPaperList();
    }
}
