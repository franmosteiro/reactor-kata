package kata.reactor.ex3;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FlatMapTest {
    @Test
    void should_return_the_expected_origin_of_each_character() {
        Flux<String> data = Flux.just("frodo", "sam", "legolas", "saruman");
        Flux<String> result = FlatMap.apply(data);

        StepVerifier.create(result)
                .expectNext("frodo - The Shire")
                .expectNext("sam - The Shire")
                .expectNext("legolas - Mirkwood")
                .expectNext("saruman - unknown")
                .expectComplete()
                .verify();
    }
}
