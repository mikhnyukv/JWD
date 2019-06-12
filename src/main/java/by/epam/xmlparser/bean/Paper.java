package by.epam.xmlparser.bean;

import java.util.Objects;

public class Paper {
    private int id;
    private PaperType type;
    private String title;
    private boolean monthly;
    private boolean color;
    private int volume;
    private boolean glossy;
    private boolean subscriptionIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaperType getType() {
        return type;
    }

    public void setType(PaperType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    public boolean isSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(boolean subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return id == paper.id &&
                monthly == paper.monthly &&
                color == paper.color &&
                volume == paper.volume &&
                glossy == paper.glossy &&
                subscriptionIndex == paper.subscriptionIndex &&
                type == paper.type &&
                Objects.equals(title, paper.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, monthly, color, volume, glossy, subscriptionIndex);
    }
}
