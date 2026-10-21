package pillars_of_object_oriented_programming.encapsulation.student_grade_using_encapsulation;

 class StudentMarks extends StudentData{
     // default access modifier
     double marks;

    // public access modifier
    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

   // protected access modifier
   private String grading(double marks){
        if(marks >= 90){
            return "A";
        }else if(marks >= 80){
            return "B";
        }else if(marks >= 70){
            return "C";
        }else if(marks >= 60){
            return "D";
        }else if(marks >= 50){
            return "Just Pass";
        }
        return "Failed";
    }


    // Here we use polymorphism concept to override the existing method
    @Override
    public String toString() {
        return "Student Name : "+getFirstName()+" "
                +getLastName()+" Student Email Id: "+getEmail()
                +" Student Marks: "+getMarks()+" Student Grade: "+grading(getMarks());
    }
}
