package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;

import java.util.List;

public abstract class BaseBuilderService {
    protected List<Paper> paperList;

    public List<Paper> getPaperList() {
        return paperList;
    }

    public abstract void buildID();
    public abstract void buildType();
    public abstract void buildColor();
    public abstract void buildTitle();
    public abstract void buildMonthly();
    public abstract void buildVolume();
    public abstract void buildGlossy();
    public abstract void buildSubscriptionIndex();
}
