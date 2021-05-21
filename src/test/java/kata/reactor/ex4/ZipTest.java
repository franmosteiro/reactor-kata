package kata.reactor.ex4;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ZipTest {
    @Test
    void should_return_origin_and_favourite_number() {
        Flux<String> data = Flux.just("frodo", "sam", "legolas");
        Flux<String> result = Zip.apply(data);

        StepVerifier.create(result)
                .expectNext("frodo - The Shire - 2")
                .expectNext("sam - The Shire - 9")
                .expectNext("legolas - Mirkwood - number of arrows in their quiver")
                .expectComplete()
                .verify();
    }
}
