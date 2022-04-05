package hajicoin.hajicoin;

public abstract class Coin {
    protected int price;
    protected int randomPercent; // 최대 9
    protected int sleepTime;

    public Coin(int price, int randomPercent, int sleepTime) {
        this.price = price;
        this.randomPercent = randomPercent;
    }

    public abstract void randomCoin() throws InterruptedException;
}
