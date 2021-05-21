package kata.reactor.ex2;

import reactor.core.publisher.Flux;

import java.util.Locale;

public class FilterUppercase {
    public static Flux<String> apply(Flux<String> data) {
        return data.filter(s -> s.toUpperCase(Locale.ROOT).equals(s));
    }
}
