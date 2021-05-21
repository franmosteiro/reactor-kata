package kata.reactor.ex3;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class FlatMap {
    public static Flux<String> apply(Flux<String> data) {
        return data.flatMap(character -> FlatMap.originForCharacter(character).map(site -> character + " - " + site));
    }

    private static Mono<String> originForCharacter(String character) {
        Map<String, String> origins = Map.of(
                "frodo", "The Shire",
                "sam", "The Shire",
                "legolas", "Mirkwood",
                "saruman", "unknown"
        );

        return Mono.just(origins.get(character));
    }
}
