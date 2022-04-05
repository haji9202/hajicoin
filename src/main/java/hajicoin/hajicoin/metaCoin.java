package hajicoin.hajicoin;

import java.util.Random;

public class metaCoin extends Coin {

    public metaCoin(int price, int randomPercent, int sleepTime) {
        super(price, randomPercent, sleepTime);
    }

    @Override
    public void randomCoin() throws InterruptedException {
        Random random = new Random();
        int randomPercentNext = random.nextInt(9);

        if (randomPercent >= randomPercentNext);
            price = price * randomPercent;
            Thread.sleep(sleepTime * 1000);
    }
}
