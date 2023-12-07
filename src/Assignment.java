import java.time.LocalDate;

public class Assignment extends Test {
    private LocalDate Assignment_startDate;
    private LocalDate Assignment_Deadline;

    public Assignment() {
    }

    public Assignment(LocalDate Assignment_startDate, LocalDate Assignment_Deadline) {
        this.Assignment_startDate = Assignment_startDate;
        this.Assignment_Deadline = Assignment_Deadline;

    }

    public Assignment(int id, String Title, int max_score, String date, String Assignment_startDate, String assignment_Deadline) {
        super(id, Title, max_score, date);
        this.Assignment_startDate = LocalDate.parse(Assignment_startDate);
        this.Assignment_Deadline = LocalDate.parse(assignment_Deadline);
    }

    public void setAssignment_startDate(LocalDate assignment_startDate) {
        Assignment_startDate = assignment_startDate;
    }

    public LocalDate getAssignment_startDate() {
        return Assignment_startDate;
    }

    public void set_Assignment_deadline(LocalDate assignment_Deadline) {
        Assignment_Deadline = assignment_Deadline;
    }

    public LocalDate getAssignment_Deadline() {
        return Assignment_Deadline;
    }
    public void setMax_score(int max_score) {
        while (true) {
            System.out.println("Enter a grade for this assignment that doesn't exceed 20 marks ");
            if( max_score<= 20 ) {
                setMax_score(max_score);
                break;
            }
            else if (max_score > 20 ) {
                System.out.println("Invalid Grade Please try again ! ");
            }

        }
    }


}