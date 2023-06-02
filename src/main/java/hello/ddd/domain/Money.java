package hello.ddd.domain;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money add(int money) {
        return new Money(this.value + money);
    }

    public int getValue() {
        return value;
    }
}
