public class Student {
    String name,stuNo;
    int classes;

    Course[] courses;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course[] courses) {

        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;

        this.courses = courses;

        calcAvarage();

        this.isPass = false;
    }


    public void addBulkExamNote(Course[] courses, double[][] notes) {

        if (notes.length == courses.length) {

            for (int i = 0; i < courses.length; i++) {

                courses[i].notes = notes[i];
            }
        }
    }

    public void addBulkExamNote(double[] notes) {

            if (notes.length == this.courses.length) {

                for (int i = 0; i < this.courses.length; i++) {

                    this.courses[i].notes = notes;
                }
            }
        }


    public void isPass() {
        int count = 0;
        for (Course course : this.courses) {
            if (course.finalNote >= 55) {
                count++;
            }
        }

        if (count == this.courses.length) {
            this.isPass = true;
            System.out.println("Tebrikler. Sınıfı Geçtiniz.");
        } else {
            this.isPass = false;
            System.out.println("Sınıfta Kaldınız.");
        }
    }


    public void calcAvarage() {
        for (Course course : this.courses) {
            course.calcFinalNote();
            this.avarage += course.finalNote;
        }
        this.avarage /= this.courses.length;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        for (Course course : this.courses) {
            System.out.println(course.name + " Notu : " + course.finalNote);
        }
        System.out.println("Ortalama : " + this.avarage);
        System.out.println("=========================");
    }
}