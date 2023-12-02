public class StudentGrades{
        private  double assignmentGrade;
        private  double quizGrade;
        private  double midTermGrade;
        private  double finalGrade;
        private double attendanceGrade;
        public StudentGrades(){}
        public StudentGrades(double assignmentGrade, double quizGrade, double midTermGrade, double finalGrade, double attendanceGrade){
            this.assignmentGrade=assignmentGrade; //20
            this.quizGrade=quizGrade;             //10
            this.midTermGrade=midTermGrade;       //15
            this.finalGrade=finalGrade;           //50
            this.attendanceGrade=attendanceGrade; //5
        }
        public void setAssignmentGrade(double assignmentGrade) {
            this.assignmentGrade = assignmentGrade;
        }
        public void setQuizGrade(double quizGrade) {
            this.quizGrade = quizGrade;
        }
        public void setMidTermGrade(double midTermGrade) {
            this.midTermGrade = midTermGrade;
        }
        public void setFinalGrade(double finalGrade) {
            this.finalGrade = finalGrade;
        }
        public void setAttendanceGrade(double attendanceGrade) {
            this.attendanceGrade = attendanceGrade;
        }
        public double getAssignmentGrade() {
            return assignmentGrade;
        }
        public double getQuizGrade() {
            return quizGrade;
        }
        public double getMidTermGrade() {
            return midTermGrade;
        }
        public double getFinalGrade() {
            return finalGrade;
        }
        public double getAttendanceGrade() {
            return attendanceGrade;
        }
        public double CalcTotalGrade(){
            double totalMark=(assignmentGrade + quizGrade + midTermGrade + finalGrade + attendanceGrade);
            return totalMark;
        }
        public double Calcscale(double totalMark){
            double scale;
            if(totalMark<=100 && totalMark>=93){
                scale=4.0;
            } else if (totalMark<93 && totalMark>=89) {
                scale=3.7;
            } else if (totalMark<89 && totalMark>=84) {
                scale=3.3;
            } else if (totalMark<84 && totalMark>=80 ) {
                scale=3.0;
            } else if (totalMark<80 && totalMark>=76 ) {
                scale=2.7;
            } else if (totalMark<76 && totalMark>=73) {
                scale=2.3;
            } else if (totalMark<73 && totalMark>=70) {
                scale=2.0;
            } else if (totalMark<70 && totalMark>=67) {
                scale=1.7;
            } else if (totalMark<67 && totalMark>=64) {
                scale=1.3;
            } else if (totalMark<64 && totalMark>=60) {
                scale=1.0;
            }else{
                scale=0.0;
            }
            return scale;
        }
        public String CalcLetterGrade(double totalMark){
            String letterGrade;
            if(totalMark>=89 && totalMark<=100) {
                letterGrade = "A";
            }
            else if(totalMark>=76 && totalMark<=88){
                letterGrade = "B";
            }
            else if(totalMark>=67 && totalMark<=75) {
                letterGrade = "C";
            }
            else if(totalMark>=60 && totalMark<=67) {
                letterGrade = "D";
            }
            else{
                letterGrade="F";
            }
            return letterGrade;
        }
        public void DisplayReport(String studentName ,int id){
            double courseGrade=CalcTotalGrade();
            double courseScale=Calcscale(courseGrade);
            String courseLetterGrade=CalcLetterGrade(courseGrade);
            System.out.println("Student Name: " + studentName);
            System.out.println("Student ID: " + id);
            System.out.println("Midterm: " + midTermGrade);
            System.out.println("Assignment: " + assignmentGrade);
            System.out.println("Quiz: " + quizGrade);
            System.out.println("Attendance:" + attendanceGrade);
            System.out.println("Final:" + finalGrade);
            System.out.println("Total Grade: " +courseGrade);
            System.out.println("Points: " + courseScale);
            System.out.println("Letter Grade: " +courseLetterGrade);
        }

    public void DisplayReport(){
        double courseGrade=CalcTotalGrade();
        double courseScale=Calcscale(courseGrade);
        String courseLetterGrade=CalcLetterGrade(courseGrade);
        System.out.println("Midterm: " + midTermGrade);
        System.out.println("Assignment: " + assignmentGrade);
        System.out.println("Quiz: " + quizGrade);
        System.out.println("Attendance:" + attendanceGrade);
        System.out.println("Final:" + finalGrade);
        System.out.println("Total Grade: " +courseGrade);
        System.out.println("Points: " + courseScale);
        System.out.println("Letter Grade: " +courseLetterGrade);
    }
    }//class


//    public double CalcGpa(double creditHour[],double scales[]){
//        double sum=0; //  sums of (hour*scale)
//        double totalHours =0;
//        for(int i=0;i<creditHour.length;i++){
//          sum=sum + (creditHour[i]*scales[i]);
//        }
//        for(int i=0;i<creditHour.length;i++){
//            totalHours+=creditHour[i];
//        }
//        return (sum/totalHours);
//    }

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
