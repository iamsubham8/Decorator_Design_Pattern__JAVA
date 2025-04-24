// Problem: Decorator Pattern - Elite Transformation
// 🎯 Scenario:
// A student from an underprivileged background wishes to transform themselves to fit in with elite students.
// They aim to improve their dressing and speaking skills, but these enhancements should be modular and extendable, without altering the base student class.

// You are asked to simulate this transformation using the Decorator Design Pattern.

// 🔶 Q1: Identify the appropriate design pattern for this scenario.
// Answer: Decorator Pattern

// 🔶 Q2: Why is the Decorator Pattern suitable for this case?
// Answer:
// The Decorator Pattern allows behavior to be added to individual objects dynamically, without modifying the base class. It supports modular enhancements like "dressing well" or "speaking fluently" that can be composed flexibly.

// 🔶 Q3: Implement the following components using Java:
// Base Interface: Student with a method String show();

// Concrete Component: UnderprivilegedStudent

// Abstract Decorator: StudentDecorator that implements Student

// Concrete Decorators:

// DressWell — adds dressing behavior

// SpeakWell — adds fluent speaking behavior

// Test Class: Create a decorated student that combines both enhancements and prints the result.

// 🔶 Q4: What is the output of your program if the base student is decorated with both DressWell and SpeakWell?
// Expected Output:

// csharp
// Copy
// Edit
// Underprivileged Student with good dressing with good speaking skills
// 🔶 Q5: How can you extend this pattern to add more traits (e.g., confidence, discipline) without modifying existing code?
// Answer:
// By creating new decorator classes like ConfidentStudent or DisciplinedStudent that extend StudentDecorator. Each decorator adds its own behavior and can be combined with others.



// Step 1: Create the base Student interface
interface Student {
    void present();
}

// Step 2: Create the ConcreteComponent - UnderprivilegedStudent
class UnderprivilegedStudent implements Student {
    @Override
    public void present() {
        System.out.println("I am an underprivileged student.");
    }
}

// Step 3: Create the Decorator class
abstract class StudentDecorator implements Student {
    protected Student decoratedStudent;

    public StudentDecorator(Student student) {
        this.decoratedStudent = student;
    }

    public void present() {
        decoratedStudent.present();
    }
}

// Step 4: Concrete Decorators - Dressing and Speaking
class WellDressedStudent extends StudentDecorator {
    public WellDressedStudent(Student student) {
        super(student);
    }

    @Override
    public void present() {
        super.present();
        addDressing();
    }

    private void addDressing() {
        System.out.println("Now I am dressed like an elite student.");
    }
}

class FluentSpeakingStudent extends StudentDecorator {
    public FluentSpeakingStudent(Student student) {
        super(student);
    }

    @Override
    public void present() {
        super.present();
        addSpeakingSkill();
    }

    private void addSpeakingSkill() {
        System.out.println("Now I can speak fluently like an elite student.");
    }
}

// Step 5: Test class
public class EliteTransformation {
    public static void main(String[] args) {
        // Base underprivileged student
        Student student = new UnderprivilegedStudent();

        // Apply transformations
        Student wellDressed = new WellDressedStudent(student);
        Student eliteStudent = new FluentSpeakingStudent(wellDressed);

        // Final presentation
        eliteStudent.present();
    }
}