package kata.reactor.ex5;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.function.Function;

public class FlatMapFlatMapExample {
    private static final BigDecimal TWO = new BigDecimal(2);
    private static final BigDecimal TWELVE = new BigDecimal(12);

    public static Flux<Pricing> apply(Flux<Offer> offers) {
        return offers.flatMap(offer -> pricingStrategies().flatMap(pricing -> pricing.apply(offer)));
    }

    private static Flux<Function<Offer, Flux<Pricing>>> pricingStrategies() {
        return Flux.just(
                (offer) -> offer.getProduct().equals("Clasica") ? Flux.from(applyClasica(offer)) : Flux.empty(),
                (offer) -> offer.getProduct().equals("Tarifa Justa") ? Flux.from(applyTJ(offer)) : Flux.empty(),
                (offer) -> offer.getProduct().equals("Indexada") ? Flux.from(applyIndexada(offer)) : Flux.empty()
        );
    }

    private static Mono<Pricing> applyClasica(Offer offer) {
        return Mono.just(new Pricing(offer, offer.getEnergyPrice().multiply(TWO), offer.getEnergyPrice().multiply(TWELVE)));
    }

    private static Mono<Pricing> applyTJ(Offer offer) {
        return Mono.just(new Pricing(offer, offer.getEnergyPrice().multiply(TWO), BigDecimal.ONE));
    }

    private static Flux<Pricing> applyIndexada(Offer offer) {
        return Flux.just(new Pricing(offer, offer.getEnergyPrice().multiply(TWO), TWO));
    }
}
