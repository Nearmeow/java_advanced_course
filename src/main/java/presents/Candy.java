package presents;

public class Candy extends Sweet {
    private String filling;
    public Candy(String name, double weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return String.format("Candy - [%s, filling - %s]", super.toString(), filling);
    }
}
