package EffectiveJava.LamdaStream;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    public static void main(String[] args) {
        primse().map(p -> BigInteger.TWO.pow(p.intValueExact())
                                        .subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primse() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}
