package sample;

public class StudentRecord {
    private final String SID;
    private final float assignments;
    private final float midterm;
    private final float finalExam;
    private float finalMark;

    public StudentRecord(String SID, float assignments, float midterm, float finalExam) {
        this.SID = SID;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;

    }


    public float getFinalMark(){
        finalMark = (assignments * 0.20f) + (midterm * 0.30f) + (finalExam * 0.50f);
        return finalMark;
    }

    public String getLetterGrade(){
        if(finalMark < 50.0f){
            return "F";
        }
        else if(finalMark < 60.0f){
            return "D";
        }
        else if (finalMark < 70.0f){
            return "C";
        }
        else if (finalMark < 80.0f){
            return "B";
        }
        else {
            return "A";
        }
    }


    public String getSID(){
        return SID;
    }

    public float getMidterm(){
        return midterm;
    }

    public float getAssignments(){
        return assignments;
    }

    public float getFinalExam(){
        return finalExam;
    }
}




