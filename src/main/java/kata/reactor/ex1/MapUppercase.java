package kata.reactor.ex1;

import reactor.core.publisher.Flux;

public class MapUppercase {
    public static Flux<String> apply(Flux<String> data) {
        return data;
    }
}
