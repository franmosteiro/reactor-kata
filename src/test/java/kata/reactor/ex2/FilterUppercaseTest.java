package kata.reactor.ex2;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FilterUppercaseTest {
    @Test
    void should_return_only_uppercase() {
        Flux<String> data = Flux.just("frodo", "SAM", "sarUman", "LEGOLAS");
        Flux<String> result = FilterUppercase.apply(data);

        StepVerifier.create(result)
                .expectNext("SAM")
                .expectNext("LEGOLAS")
                .expectComplete()
                .verify();
    }
}
