package EffectiveJava.EnumStudy;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL, TEST}

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
