package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.bean.PaperType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class StAXParserTest {

    @Test
    public void StAXParserTest() throws ServiceException {
        List<Paper> paperList = new ArrayList<Paper>();
        Paper paper1 = new Paper();
        Paper paper2 = new Paper();
        Paper paper3 = new Paper();
        Paper paper4 = new Paper();
        Paper paper5 = new Paper();
        Paper paper6 = new Paper();
        Paper paper7 = new Paper();
        Paper paper8 = new Paper();
        Paper paper9 = new Paper();
        Paper paper10 = new Paper();
        Paper paper11 = new Paper();
        Paper paper12 = new Paper();
        Paper paper13 = new Paper();
        Paper paper14 = new Paper();
        Paper paper15 = new Paper();
        Paper paper16 = new Paper();

        paper1.setId(1);
        paper2.setId(2);
        paper3.setId(3);
        paper4.setId(4);
        paper5.setId(5);
        paper6.setId(6);
        paper7.setId(7);
        paper8.setId(8);
        paper9.setId(9);
        paper10.setId(10);
        paper11.setId(11);
        paper12.setId(12);
        paper13.setId(13);
        paper14.setId(14);
        paper15.setId(15);
        paper16.setId(16);

        paper1.setType(PaperType.MAGAZINE);
        paper2.setType(PaperType.NEWSPAPER);
        paper3.setType(PaperType.BOOKLET);
        paper4.setType(PaperType.NEWSPAPER);
        paper5.setType(PaperType.NEWSPAPER);
        paper6.setType(PaperType.NEWSPAPER);
        paper7.setType(PaperType.NEWSPAPER);
        paper8.setType(PaperType.NEWSPAPER);
        paper9.setType(PaperType.NEWSPAPER);
        paper10.setType(PaperType.NEWSPAPER);
        paper11.setType(PaperType.NEWSPAPER);
        paper12.setType(PaperType.NEWSPAPER);
        paper13.setType(PaperType.NEWSPAPER);
        paper14.setType(PaperType.NEWSPAPER);
        paper15.setType(PaperType.NEWSPAPER);
        paper16.setType(PaperType.NEWSPAPER);

        paper1.setSubscriptionIndex(true);
        paper2.setSubscriptionIndex(true);
        paper3.setSubscriptionIndex(true);
        paper4.setSubscriptionIndex(true);
        paper5.setSubscriptionIndex(true);
        paper6.setSubscriptionIndex(true);
        paper7.setSubscriptionIndex(true);
        paper8.setSubscriptionIndex(true);
        paper9.setSubscriptionIndex(true);
        paper10.setSubscriptionIndex(true);
        paper11.setSubscriptionIndex(true);
        paper12.setSubscriptionIndex(true);
        paper13.setSubscriptionIndex(true);
        paper14.setSubscriptionIndex(true);
        paper15.setSubscriptionIndex(true);
        paper16.setSubscriptionIndex(true);

        paper1.setGlossy(true);
        paper2.setGlossy(true);
        paper3.setGlossy(true);
        paper4.setGlossy(true);
        paper5.setGlossy(true);
        paper6.setGlossy(true);
        paper7.setGlossy(true);
        paper8.setGlossy(true);
        paper9.setGlossy(true);
        paper10.setGlossy(true);
        paper11.setGlossy(true);
        paper12.setGlossy(true);
        paper13.setGlossy(true);
        paper14.setGlossy(true);
        paper15.setGlossy(true);
        paper16.setGlossy(true);

        paper1.setVolume(35);
        paper2.setVolume(45);
        paper3.setVolume(75);
        paper4.setVolume(200);
        paper5.setVolume(20);
        paper6.setVolume(200);
        paper7.setVolume(200);
        paper8.setVolume(200);
        paper9.setVolume(200);
        paper10.setVolume(200);
        paper11.setVolume(200);
        paper12.setVolume(200);
        paper13.setVolume(200);
        paper14.setVolume(200);
        paper15.setVolume(200);
        paper16.setVolume(200);

        paper1.setColor(true);
        paper2.setColor(true);
        paper3.setColor(true);
        paper4.setColor(true);
        paper5.setColor(true);
        paper6.setColor(true);
        paper7.setColor(true);
        paper8.setColor(true);
        paper9.setColor(true);
        paper10.setColor(true);
        paper11.setColor(true);
        paper12.setColor(true);
        paper13.setColor(true);
        paper14.setColor(true);
        paper15.setColor(true);
        paper16.setColor(true);

        paper1.setMonthly(true);
        paper2.setMonthly(true);
        paper3.setMonthly(true);
        paper4.setMonthly(true);
        paper5.setMonthly(true);
        paper6.setMonthly(true);
        paper7.setMonthly(true);
        paper8.setMonthly(true);
        paper9.setMonthly(true);
        paper10.setMonthly(true);
        paper11.setMonthly(true);
        paper12.setMonthly(true);
        paper13.setMonthly(true);
        paper14.setMonthly(true);
        paper15.setMonthly(true);
        paper16.setMonthly(true);

        paper1.setTitle("Vogue");
        paper2.setTitle("Forbs");
        paper3.setTitle("CarDrift");
        paper4.setTitle("Garden");
        paper5.setTitle("Village");
        paper6.setTitle("Garden");
        paper7.setTitle("YourCity");
        paper8.setTitle("Garden");
        paper9.setTitle("Garden");
        paper10.setTitle("Garden");
        paper11.setTitle("Garden");
        paper12.setTitle("Garden");
        paper13.setTitle("Garden");
        paper14.setTitle("Garden");
        paper15.setTitle("Garden");
        paper16.setTitle("Garden");

        paperList.add(paper1);
        paperList.add(paper2);
        paperList.add(paper3);
        paperList.add(paper4);
        paperList.add(paper5);
        paperList.add(paper6);
        paperList.add(paper7);
        paperList.add(paper8);
        paperList.add(paper9);
        paperList.add(paper10);
        paperList.add(paper11);
        paperList.add(paper12);
        paperList.add(paper13);
        paperList.add(paper14);
        paperList.add(paper15);
        paperList.add(paper16);

        StAXPaperParser parser = new StAXPaperParser();
        parser.parse("papers.xml");
        List<Paper> actualList = parser.getPaperList();
        Paper[] expected = new Paper[paperList.size()];
        for(int i = 0; i < expected.length; i++) {
            expected[i] = paperList.get(i);
        }
        Paper[] actual = new Paper[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }

        Assert.assertArrayEquals(expected, actual);
    }
}
