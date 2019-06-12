package by.epam.xmlparser.service.impl;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.bean.PaperType;
import by.epam.xmlparser.service.BaseBuilderService;
import by.epam.xmlparser.service.ServiceException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DOMBuilderServiceImpl extends BaseBuilderService {
    private Document document;
    private NodeList nodeList;
    private final Logger logger = Logger.getLogger(DOMBuilderServiceImpl.class);

    public DOMBuilderServiceImpl(String filePath) throws ServiceException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(ClassLoader.getSystemResourceAsStream(filePath));
            nodeList = document.getDocumentElement().getChildNodes();
            paperList = new ArrayList<Paper>();
        } catch(ParserConfigurationException e) {
            throw new ServiceException("Parser exception", e);
        } catch (SAXException e) {
            throw new ServiceException("SAX exception", e);
        } catch (IOException e) {
            throw new ServiceException("IO exception", e);
        }
    }

    public void buildID() {
        logger.info("ID building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Paper paper = new Paper();
                    paper.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        paperList.get(i).setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
                        j++;
                        break;
                    }
                }
            }
        }
    }

    public void buildType() {
        logger.info("Type building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Paper paper = new Paper();
                    String typeString = node.getAttributes().getNamedItem("type").getNodeValue();
                    if (typeString.equals(PaperType.MAGAZINE.getPaperType())) {
                        paper.setType(PaperType.MAGAZINE);
                    } else if (typeString.equals(PaperType.NEWSPAPER.getPaperType())) {
                        paper.setType(PaperType.NEWSPAPER);
                    } else if (typeString.equals(PaperType.BOOKLET.getPaperType())) {
                        paper.setType(PaperType.BOOKLET);
                    }
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        String typeString = node.getAttributes().getNamedItem("type").getNodeValue();
                        if (typeString.equals(PaperType.MAGAZINE.getPaperType())) {
                            paperList.get(i).setType(PaperType.MAGAZINE);
                        } else if (typeString.equals(PaperType.NEWSPAPER.getPaperType())) {
                            paperList.get(i).setType(PaperType.NEWSPAPER);
                        } else if (typeString.equals(PaperType.BOOKLET.getPaperType())) {
                            paperList.get(i).setType(PaperType.BOOKLET);
                        }
                        j++;
                        break;
                    }
                }
            }
        }
    }

    public void buildColor() {
        logger.info("Color building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Paper paper = new Paper();
                    paper.setColor(Boolean.parseBoolean(node.getAttributes().getNamedItem("color").getNodeValue()));
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        paperList.get(i).setColor(Boolean.parseBoolean(node.getAttributes().getNamedItem("color").getNodeValue()));
                        j++;
                        break;
                    }
                }
            }
        }
    }

    public void buildTitle() {
        logger.info("Title building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node cNode = childNodes.item(1);
                if(cNode instanceof Element) {
                    String title = cNode.getLastChild().getNodeValue();
                    Paper paper = new Paper();
                    paper.setTitle(title);
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        NodeList childNodes = node.getChildNodes();
                        Node cNode = childNodes.item(1);
                        if (cNode instanceof Element) {
                            String title = cNode.getLastChild().getNodeValue();
                            paperList.get(i).setTitle(title);
                            j++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void buildMonthly() {
        logger.info("Monthly building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Paper paper = new Paper();
                    paper.setMonthly(Boolean.parseBoolean(node.getAttributes().getNamedItem("monthly").getNodeValue()));
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        paperList.get(i).setMonthly(Boolean.parseBoolean(node.getAttributes().getNamedItem("monthly").getNodeValue()));
                        j++;
                        break;
                    }
                }
            }
        }
    }

    public void buildVolume() {
        logger.info("Volume building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node cNode = childNodes.item(3);
                if(cNode instanceof Element) {
                    int volume = Integer.parseInt(cNode.getLastChild().getNodeValue());
                    Paper paper = new Paper();
                    paper.setVolume(volume);
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        NodeList childNodes = node.getChildNodes();
                        Node cNode = childNodes.item(3);
                        if (cNode instanceof Element) {
                            int volume = Integer.parseInt(cNode.getLastChild().getNodeValue());
                            paperList.get(i).setVolume(volume);
                            j++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void buildGlossy() {
        logger.info("Glossy building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node cNode = childNodes.item(5);
                if(cNode instanceof Element) {
                    Boolean glossy = Boolean.parseBoolean(cNode.getLastChild().getNodeValue());
                    Paper paper = new Paper();
                    paper.setGlossy(glossy);
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        NodeList childNodes = node.getChildNodes();
                        Node cNode = childNodes.item(5);
                        if (cNode instanceof Element) {
                            Boolean glossy = Boolean.parseBoolean(cNode.getLastChild().getNodeValue());
                            paperList.get(i).setGlossy(glossy);
                            j++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void buildSubscriptionIndex() {
        logger.info("Subscription index building...");
        if(paperList.size() == 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node cNode = childNodes.item(7);
                if(cNode instanceof Element) {
                    Boolean subscription = Boolean.parseBoolean(cNode.getLastChild().getNodeValue());
                    Paper paper = new Paper();
                    paper.setSubscriptionIndex(subscription);
                    paperList.add(paper);
                }
            }
        } else {
            int j = 0;
            for (int i = 0; i < paperList.size(); i++) {
                for (; j < nodeList.getLength(); j++) {
                    Node node = nodeList.item(j);
                    if (node instanceof Element) {
                        NodeList childNodes = node.getChildNodes();
                        Node cNode = childNodes.item(7);
                        if (cNode instanceof Element) {
                            Boolean subscription = Boolean.parseBoolean(cNode.getLastChild().getNodeValue());
                            paperList.get(i).setSubscriptionIndex(subscription);
                            j++;
                            break;
                        }
                    }
                }
            }
        }
    }
}
