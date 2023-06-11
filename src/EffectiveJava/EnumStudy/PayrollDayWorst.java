package EffectiveJava.EnumStudy;

public enum PayrollDayWorst {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    // 위험한 코드!! 상수가 추가된다면 switch 문 수정이 필수다!!
    // 해결책 1. 잔업수당 계산 코드를 상수별로 중복 작성 --> MONDAY {잔업수당 계산 코드 중복장성}
    // 해결책 2. 도우미 메서드 작성(주말, 주중 코드 나눠서) --> overPay 메서드 구현후 주말만 재정의해서 쓴다 --> switch문과 동일한 문제 발생!!
    // 완벽한 해결책 --> 전략 열거 타입 패턴
    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay = switch (this) {
            case SATURDAY, SUNDAY -> basePay / 2;
            default -> minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        };

        return basePay + overtimePay;
    }
}
