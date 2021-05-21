package kata.reactor.ex1;

import reactor.core.publisher.Flux;

import java.util.Locale;

public class MapUppercase {
    public static Flux<String> apply(Flux<String> data) {
        return data.map(d -> d.toUpperCase(Locale.ROOT));
    }
}
