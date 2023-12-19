public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;

    double[] notes;
    double[] notePercents;

    String[] noteNames;
    int finalNote;

    public Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;

        // Midterm ve Finql Array
        this.notes = new double[2];

        // Midterm %40 Final %60
        this.notePercents = new double[2];
        this.notePercents[0] = 40;
        this.notePercents[1] = 60;

        // Exam Names
        this.noteNames = new String[2];
        this.noteNames[0] = "Midterm";
        this.noteNames[1] = "Final";

    }

    public Course(String name, String code, String prefix, String[] noteNames, double[] notePercents) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;

        this.noteNames = new String[noteNames.length];

        for (int i = 0; i < noteNames.length; i++) {
            this.noteNames[i] = noteNames[i];
        }

        this.notePercents = new double[notePercents.length];

        for (int i = 0; i < notePercents.length; i++) {
            this.notePercents[i] = notePercents[i];
        }

        this.notes = new double[noteNames.length];
        this.noteNames = noteNames;

    }

    public void addNote(String noteName, double note) {
        // Check if noteName is in noteNames
        boolean isNoteNameInNoteNames = false;
        for (String noteNameInNoteNames : this.noteNames) {
            if (noteNameInNoteNames.equals(noteName)) {
                isNoteNameInNoteNames = true;
                break;
            }
        }
    }

    public void addBulkExamNote(String[] noteNames, double[] notes) {
        // Check if noteNames and notes have same length
        if (noteNames.length == notes.length) {
            // use addNote method
            for (int i = 0; i < noteNames.length; i++) {
                addNote(
                        noteNames[i],
                        notes[i]);
            }
        } else {
            System.out.println("Not isimleri ve notlar aynı uzunlukta değil.");
        }
    }

    public void calcFinalNote() {
        // Calculate final note and assign to finalNote
        this.finalNote = 0;
        for (int i = 0; i < this.notes.length; i++) {
            this.finalNote += this.notes[i] * this.notePercents[i] / 100;
        }
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }

}