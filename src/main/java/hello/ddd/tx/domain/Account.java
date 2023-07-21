package hello.ddd.tx.domain;

public class Account {
    private String no;
    private int amounts;

    public Account(String no, int amounts) {
        this.no = no;
        this.amounts = amounts;
    }

    public int withdraw(int money) {
        if(amounts < money) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.amounts -= money;

        return money;
    }

    public String getNo() {
        return no;
    }

    public int getAmounts() {
        return amounts;
    }
}
