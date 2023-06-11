package EffectiveJava.EnumStudy;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    },
    ;
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // symbol을 입력값으로 받아 Operation 인스턴스 찾아 반환
    // stringToEnum 초기화 시점은 상수들(PLUS, MINUS..)이 생성된 후 정적필드 초기화 될 때
    private static final Map<String, Operation> stringToEnum = Stream.of(Operation.values()).collect(Collectors.toMap(
            Objects::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public abstract double apply(double x, double y);
}
