package EffectiveJava.EnumStudy;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    TIMES("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right),
    ;
    private final String symbol;
    private final DoubleBinaryOperator operator;

    Operation(String symbol, DoubleBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
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

    public double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }
}
