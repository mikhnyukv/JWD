package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.bean.PaperType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SAXPaperHandler extends DefaultHandler {
    private List<Paper> paperList = new ArrayList<Paper>();
    private Paper paper;
    private String content;

    @Override
    public void startDocument() throws SAXException {
        paperList.clear();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if(qName.equals("Paper")) {
            paper = new Paper();
            paper.setId(Integer.parseInt(attributes.getValue("id")));
            paper.setMonthly(Boolean.parseBoolean(attributes.getValue("monthly")));
            paper.setColor(Boolean.parseBoolean(attributes.getValue("color")));
            String typeString = attributes.getValue("type");
            if (typeString.equals(PaperType.MAGAZINE.getPaperType())) {
                paper.setType(PaperType.MAGAZINE);
            } else if (typeString.equals(PaperType.NEWSPAPER.getPaperType())) {
                paper.setType(PaperType.NEWSPAPER);
            } else if (typeString.equals(PaperType.BOOKLET.getPaperType())) {
                paper.setType(PaperType.BOOKLET);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch(qName) {
            case "Paper":
                paperList.add(paper);
                break;
            case "Title":
                paper.setTitle(content);
                break;
            case "Volume":
                paper.setVolume(Integer.parseInt(content));
                break;
            case "Glossy":
                paper.setGlossy(Boolean.parseBoolean(content));
                break;
            case "SubscriptionIndex":
                paper.setSubscriptionIndex(Boolean.parseBoolean(content));
                break;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public List<Paper> getPaperList() {
        return paperList;
    }
}
