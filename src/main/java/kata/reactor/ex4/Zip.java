package kata.reactor.ex4;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class Zip {
    public static Flux<String> apply(Flux<String> data) {
        return data.flatMap(character ->
            Mono.zip(
                    Zip.originForCharacter(character),
                    Zip.favouriteNumberForCharacter(character)
            ).map(mix -> character + " - " + mix.getT1() + " - " + mix.getT2())
        );
    }

    private static Mono<String> originForCharacter(String character) {
        Map<String, String> origins = Map.of(
                "frodo", "The Shire",
                "sam", "The Shire",
                "legolas", "Mirkwood"
        );

        return Mono.just(origins.get(character));
    }

    private static Mono<String> favouriteNumberForCharacter(String character) {
        Map<String, String> numbers = Map.of(
                "frodo", "2",
                "sam", "9",
                "legolas", "number of arrows in their quiver"
        );

        return Mono.just(numbers.get(character));
    }
}
