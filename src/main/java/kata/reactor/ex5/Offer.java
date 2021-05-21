package kata.reactor.ex5;

import java.math.BigDecimal;

public class Offer {
    private final String product;
    private final BigDecimal energyPrice;

    public Offer(String product, BigDecimal energyPrice) {
        this.product = product;
        this.energyPrice = energyPrice;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getEnergyPrice() {
        return energyPrice;
    }
}
