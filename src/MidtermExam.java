
public class MidtermExam extends Test {
    private String Exam_Location;
    private int Exam_Duration;
    public MidtermExam (){}

    @Override
    public void setID(int id) {
        super.setID(id);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setMax_score(int max_score) {
        super.setMax_score(max_score);
    }

    @Override
    public void setMark(double mark) {
        super.setMark(mark);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    public void setExam_Location(String exam_Location) {
        Exam_Location = exam_Location;
    }

    public void setExam_Duration(int exam_Duration) {
        Exam_Duration = exam_Duration;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public String getTitle(String title) {
        return super.getTitle(title);
    }

    @Override
    public int getMax_score() {
        return super.getMax_score();
    }

    @Override
    public double getMark() {
        return super.getMark();
    }

    @Override
    public String getDate() {
        return super.getDate();
    }

    public int getExam_Duration() {
        return Exam_Duration;
    }

    public String getExam_Location() {
        return Exam_Location;
    }
}
