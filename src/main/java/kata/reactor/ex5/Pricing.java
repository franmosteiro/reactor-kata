package kata.reactor.ex5;

import java.math.BigDecimal;
import java.util.Objects;

public class Pricing {
    private final Offer offer;
    private final BigDecimal monthlySavings;
    private final BigDecimal annualSavings;

    public Pricing(Offer offer, BigDecimal monthlySavings, BigDecimal annualSavings) {
        this.offer = offer;
        this.monthlySavings = monthlySavings;
        this.annualSavings = annualSavings;
    }

    public Offer getOffer() {
        return offer;
    }

    public BigDecimal getMonthlySavings() {
        return monthlySavings;
    }

    public BigDecimal getAnnualSavings() {
        return annualSavings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pricing pricing = (Pricing) o;
        return Objects.equals(offer, pricing.offer) && Objects.equals(monthlySavings, pricing.monthlySavings) && Objects.equals(annualSavings, pricing.annualSavings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offer, monthlySavings, annualSavings);
    }
}
