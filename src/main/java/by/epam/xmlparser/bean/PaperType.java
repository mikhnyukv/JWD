package by.epam.xmlparser.bean;

public enum PaperType {
    NEWSPAPER("newspaper"), MAGAZINE("magazine"), BOOKLET("booklet");

    private PaperType(String type) {
        this.type = type;
    }

    private String type;

    public String getPaperType() {
        return type;
    }
}
