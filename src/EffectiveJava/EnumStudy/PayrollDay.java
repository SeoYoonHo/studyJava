package EffectiveJava.EnumStudy;

import java.util.function.IntBinaryOperator;

import static EffectiveJava.EnumStudy.PayrollDay.PayType.WEEKDAY;
import static EffectiveJava.EnumStudy.PayrollDay.PayType.WEEKEND;

public enum PayrollDay {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY), SATURDAY(
            WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType {
        WEEKDAY((mins, payRate) -> mins <= PayType.MINS_PER_SHIFT ? 0 : (mins - PayType.MINS_PER_SHIFT) * payRate * 2),
        WEEKEND((mins, payRate) -> mins * payRate / 2);

        private final IntBinaryOperator operator;

        PayType(IntBinaryOperator operator) {
            this.operator = operator;
        }

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + operator.applyAsInt(minsWorked, payRate);
        }
    }
}
