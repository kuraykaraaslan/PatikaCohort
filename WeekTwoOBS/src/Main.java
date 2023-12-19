public class Main {
    public static void main(String[] args) {

        // Create instances of Course with their respective information
        Course mat = new Course("Matematik", "MAT101", "MAT", new String[]{"Midterm", "Final"}, new double[]{40, 60});
        Course fizik = new Course("Fizik", "FZK101", "FZK", new String[]{"Midterm", "Final"}, new double[]{40, 60});
        Course kimya = new Course("Kimya", "KMY101", "KMY" , new String[]{"Midterm", "Final"}, new double[]{40, 60});

        // Create instances of Teacher with their respective information
        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

        // Assign teachers to their respective courses
        mat.addTeacher(t1);
        fizik.addTeacher(t2);
        kimya.addTeacher(t3);

        // Create an array of courses
        Course[] courses = {mat, fizik, kimya};

        // Create an instance of Student with their respective information
        Student s1 = new Student("İnek Şaban", 4, "140144015", courses);
        double[][] s1Note = {{100, 100}, {90, 100}, {80, 100}};
        // Add exam notes for s1 using addBulkExamNote method
        s1.addBulkExamNote(courses, s1Note);
        // Check if s1 is passing or failing
        s1.isPass();

        // Create another instance of Student with their respective information
        Student s2 = new Student("Güdük Necmi", 4, "2211133", courses);
        double[][] s2Note = {{40, 60}, {50, 60}, {20, 30}};
        // Add exam notes for s2 using addBulkExamNote method
        s2.addBulkExamNote(courses, s2Note);
        // Check if s2 is passing or failing
        s2.isPass();

        // Create another instance of Student with their respective information
        Student s3 = new Student("Hayta İsmail", 4, "221121312", courses);
        double[][] s3Note = {{100, 100}, {100, 100}, {100, 100}};
        // Add exam notes for s3 using addBulkExamNote method
        s3.addBulkExamNote(courses, s3Note);
        // Check if s3 is passing or failing
        s3.isPass();
    }
}
