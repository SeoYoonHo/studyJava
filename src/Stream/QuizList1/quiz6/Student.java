package Stream.QuizList1.quiz6;

public class Student {
    private String name;
    private boolean isMale; // 성별
    private int hak; // 학년
    private int ban; // 반
    private int score;

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }

    public Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getHak() {
        return hak;
    }

    public void setHak(int hak) {
        this.hak = hak;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
