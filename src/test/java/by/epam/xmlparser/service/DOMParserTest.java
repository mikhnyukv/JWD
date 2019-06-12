package by.epam.xmlparser.service;

import by.epam.xmlparser.bean.Paper;
import by.epam.xmlparser.bean.PaperType;
import by.epam.xmlparser.service.impl.DOMBuilderServiceImpl;
import by.epam.xmlparser.service.impl.DirectorServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class DOMParserTest {

    @Test
    public void buildIDTest() throws ServiceException {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Integer> actualList = new ArrayList<Integer>();
        for (Paper paper : paperList) {
            actualList.add(paper.getId());
        }
        int[] actual = new int[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildTypeTest() throws ServiceException {
        PaperType[] expected = {PaperType.MAGAZINE, PaperType.NEWSPAPER, PaperType.BOOKLET, PaperType.NEWSPAPER,
                PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER,
                PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER,
                PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER, PaperType.NEWSPAPER};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<PaperType> actualList = new ArrayList<PaperType>();
        for (Paper paper : paperList) {
            actualList.add(paper.getType());
        }
        PaperType[] actual = new PaperType[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildMonthTest() throws ServiceException {
        boolean[] expected = {true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Boolean> actualList = new ArrayList<Boolean>();
        for (Paper paper : paperList) {
            actualList.add(paper.isMonthly());
        }
        boolean[] actual = new boolean[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildColorTest() throws ServiceException {
        boolean[] expected = {true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Boolean> actualList = new ArrayList<Boolean>();
        for (Paper paper : paperList) {
            actualList.add(paper.isColor());
        }
        boolean[] actual = new boolean[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildTitleTest() throws ServiceException {
        String[] expected = {"Vogue", "Forbs", "CarDrift", "Garden", "Village", "Garden", "YourCity", "Garden",
                "Garden", "Garden", "Garden", "Garden", "Garden", "Garden", "Garden", "Garden"};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<String> actualList = new ArrayList<String>();
        for (Paper paper : paperList) {
            actualList.add(paper.getTitle());
        }
        String[] actual = new String[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildVolumeTest() throws ServiceException {
        int[] expected = {35, 45, 75, 200, 20, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Integer> actualList = new ArrayList<Integer>();
        for (Paper paper : paperList) {
            actualList.add(paper.getVolume());
        }
        int[] actual = new int[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildGlossyTest() throws ServiceException {
        boolean[] expected = {true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Boolean> actualList = new ArrayList<Boolean>();
        for (Paper paper : paperList) {
            actualList.add(paper.isGlossy());
        }
        boolean[] actual = new boolean[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void buildSubscriptionIndexTest() throws ServiceException {
        boolean[] expected = {true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true};
        List<Paper> paperList = new DirectorServiceImpl().createPaperList(new DOMBuilderServiceImpl("papers.xml"));
        List<Boolean> actualList = new ArrayList<Boolean>();
        for (Paper paper : paperList) {
            actualList.add(paper.isSubscriptionIndex());
        }
        boolean[] actual = new boolean[actualList.size()];
        for(int i = 0; i < actual.length; i++) {
            actual[i] = actualList.get(i);
        }
        Assert.assertArrayEquals(expected, actual);
    }
}

