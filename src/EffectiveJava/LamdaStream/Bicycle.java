package EffectiveJava.LamdaStream;

public class Bicycle {
    private String yaho;

    public Bicycle(String yaho) {
        this.yaho = yaho;
    }

    public String getYaho() {
        return yaho;
    }

    public String getYaho(Bicycle bicycle) {
        return bicycle.getYaho();
    }
}
