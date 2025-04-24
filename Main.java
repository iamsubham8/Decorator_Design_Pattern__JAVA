// Step 1: Component Interface
interface Student {
    String show();
}

// Step 2: Concrete Component
class UnderprivilegedStudent implements Student {
    public String show() {
        return "Underprivileged Student";
    }
}

// Step 3: Abstract Decorator
abstract class StudentDecorator implements Student {
    protected Student student;

    public StudentDecorator(Student student) {
        this.student = student;
    }

    public String show() {
        return student.show();
    }
}

// Step 4: Concrete Decorators
class DressWell extends StudentDecorator {
    public DressWell(Student student) {
        super(student);
    }

    public String show() {
        return super.show() + " with good dressing";
    }
}

class SpeakWell extends StudentDecorator {
    public SpeakWell(Student student) {
        super(student);
    }

    public String show() {
        return super.show() + " with good speaking skills";
    }
}

// Step 5: Test
public class Main {
    public static void main(String[] args) {
        Student student = new UnderprivilegedStudent();

        // Decorate with DressWell and SpeakWell
        
        // Student eliteStudent = new SpeakWell(new DressWell(student));
       
       
        Student wellDress = new DressWell(student);
        Student eliteStudent = new SpeakWell(wellDress);

        System.out.println(eliteStudent.show());
    }
}
