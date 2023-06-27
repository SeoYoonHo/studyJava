package EffectiveJava.LamdaStream;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

public class MersennePrime {
    public static void main(String[] args) {
        Instant beforeTime = Instant.now();

        primse().map(p -> BigInteger.TWO.pow(p.intValueExact())
                                        .subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

        Instant afterTime = Instant.now();
        long diffTime = Duration.between(beforeTime, afterTime).toMillis(); // 두 개의 실행 시간
        System.out.println("실행 시간(ms): " + diffTime);
    }

    static Stream<BigInteger> primse() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
