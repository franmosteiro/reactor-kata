package kata.reactor.ex1;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MapUppercaseTest {
    @Test
    void should_convert_everything_to_uppercase() {
        Flux<String> data = Flux.just("frodo", "sam", "saruman");
        Flux<String> result = MapUppercase.apply(data);

        StepVerifier.create(result)
                .expectNext("FRODO")
                .expectNext("SAM")
                .expectNext("SARUMAN")
                .expectComplete()
                .verify();
    }
}
