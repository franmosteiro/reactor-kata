package kata.reactor.ex5;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

public class FlatMapFlatMapTest {

    public static final Offer CLASICA = new Offer("Clasica", new BigDecimal("0.13"));
    public static final Offer TARIFA_JUSTA = new Offer("Tarifa Justa", new BigDecimal("0.14"));
    public static final Offer INDEXADA = new Offer("Indexada", new BigDecimal("0.12"));

    @Test
    void should_return_pricings_for_offers() {
        Flux<Offer> offers = Flux.just(
                CLASICA,
                TARIFA_JUSTA,
                INDEXADA
        );

        Flux<Pricing> pricings = FlatMapFlatMap.apply(offers);
        StepVerifier.create(pricings)
                .expectNext(new Pricing(CLASICA, new BigDecimal("0.26"), new BigDecimal("1.56")))
                .expectNext(new Pricing(TARIFA_JUSTA, new BigDecimal("0.28"), new BigDecimal("1")))
                .expectNext(new Pricing(INDEXADA, new BigDecimal("0.24"), new BigDecimal("2")))
                .expectComplete()
                .verify();
    }

    @Test
    void should_return_pricings_for_offers_example() {
        Flux<Offer> offers = Flux.just(
                CLASICA,
                TARIFA_JUSTA,
                INDEXADA
        );

        Flux<Pricing> pricings = FlatMapFlatMapExample.apply(offers);
        StepVerifier.create(pricings)
                .expectNext(new Pricing(CLASICA, new BigDecimal("0.26"), new BigDecimal("1.56")))
                .expectNext(new Pricing(TARIFA_JUSTA, new BigDecimal("0.28"), new BigDecimal("1")))
                .expectNext(new Pricing(INDEXADA, new BigDecimal("0.24"), new BigDecimal("2")))
                .expectComplete()
                .verify();
    }
}
