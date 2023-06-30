package EffectiveJava.Method;

import java.util.Date;

public final class PeriodCopy {
    private final Date start;
    private final Date end;

    /**
     * @param start 시작 시각
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 떄 발생한다.
     * @throws NullPointerException     start나 end가 null 이면 발생한다.
     * @parm end 종료 시각; 시작 시각보다 뒤여야 한다.
     */
    // 원본이 아닌 복사본 매개변수를 사용하여 불변식을 지킨다
    public PeriodCopy(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }

    // 가변필드의 방어적 복사본을 반환한다.
    public Date Start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }
}
