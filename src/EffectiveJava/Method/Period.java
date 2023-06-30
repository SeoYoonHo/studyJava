package EffectiveJava.Method;

import java.util.Date;

// Date 객체 자체가 가변이기 때문에 불변이 아니다!!
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start 시작 시각
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 떄 발생한다.
     * @throws NullPointerException     start나 end가 null 이면 발생한다.
     * @parm end 종료 시각; 시작 시각보다 뒤여야 한다.
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }

        this.start = start;
        this.end = end;
    }

    public Date Start() {
        return start;
    }

    public Date end() {
        return end;
    }
}
