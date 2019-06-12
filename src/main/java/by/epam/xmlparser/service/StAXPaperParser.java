package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.bean.PaperType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StAXPaperParser {
    private List<Paper> paperList = new ArrayList<Paper>();
    private Paper paper;
    private String tagContent;

    public void parse(String path) throws ServiceException {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
            while(reader.hasNext()) {
                int event = reader.next();
                switch(event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if("Paper".equals(reader.getLocalName())) {
                            paper = new Paper();
                            paper.setId(Integer.parseInt(reader.getAttributeValue(0)));
                            paper.setMonthly(Boolean.parseBoolean(reader.getAttributeValue(2)));
                            paper.setColor(Boolean.parseBoolean(reader.getAttributeValue(3)));
                            String typeString = reader.getAttributeValue(1);
                            if (typeString.equals(PaperType.MAGAZINE.getPaperType())) {
                                paper.setType(PaperType.MAGAZINE);
                            } else if (typeString.equals(PaperType.NEWSPAPER.getPaperType())) {
                                paper.setType(PaperType.NEWSPAPER);
                            } else if (typeString.equals(PaperType.BOOKLET.getPaperType())) {
                                paper.setType(PaperType.BOOKLET);
                            }
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch(reader.getLocalName()) {
                            case "Paper":
                                paperList.add(paper);
                                break;
                            case "Title":
                                paper.setTitle(tagContent);
                                break;
                            case "Volume":
                                paper.setVolume(Integer.parseInt(tagContent));
                                break;
                            case "Glossy":
                                paper.setGlossy(Boolean.parseBoolean(tagContent));
                                break;
                            case "SubscriptionIndex":
                                paper.setSubscriptionIndex(Boolean.parseBoolean(tagContent));
                                break;
                        }
                        break;
                    case XMLStreamConstants.START_DOCUMENT:
                        paperList = new ArrayList<Paper>();
                        break;
                }
            }
        } catch(XMLStreamException e) {
            throw new ServiceException("XML stream exception", e);
        }
    }

    public List<Paper> getPaperList() {
        return paperList;
    }
}
