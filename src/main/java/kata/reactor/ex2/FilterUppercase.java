package kata.reactor.ex2;

import reactor.core.publisher.Flux;

public class FilterUppercase {
    public static Flux<String> apply(Flux<String> data) {
        return data;
    }
}
