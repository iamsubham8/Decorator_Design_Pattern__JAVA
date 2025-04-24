// Question 1: Text Formatter Decorator Pattern
// Your task is to implement a design pattern for decorating text with different formatting options. You should have a base interface TextFormatter with a concrete implementation PlainTextFormatter. Additionally, implement three decorator classes: BoldTextFormatter, ItalicTextFormatter, and UnderlineTextFormatter, each adding a specific formatting style to the text.

// 1. TextFormatter Interface:
// Implement an interface TextFormatter with a method:

// java
// Copy
// Edit
// String format(String text);
// that formats the given text.

// 2. PlainTextFormatter Class:
// Implement a concrete class PlainTextFormatter that implements the TextFormatter interface.

// The format(String text) method should return the input text without any additional formatting.

// 3. BoldTextFormatter Class:
// Implement a decorator class BoldTextFormatter that extends the TextFormatter interface.

// The format(String text) method should return the input text formatted in bold using:

// <b>your text</b>


// 4. ItalicTextFormatter Class:
// Implement a decorator class ItalicTextFormatter that extends the TextFormatter interface.

// The format(String text) method should return the input text formatted in italic using:

// <i>your text</i>


// 5. UnderlineTextFormatter Class:
// Implement a decorator class UnderlineTextFormatter that extends the TextFormatter interface.

// The format(String text) method should return the input text formatted with underline using:

// <u>your text</u>




// Interface for TextFormatter
interface TextFormatter {
    String format(String text);
}

// Concrete class for plain text formatting
class PlainTextFormatter implements TextFormatter {
    public String format(String text) {
        return text;
    }
}

// Abstract decorator class
abstract class Decorator implements TextFormatter {
    protected TextFormatter tf;

    public Decorator(TextFormatter tf) {
        this.tf = tf;
    }

    public String format(String text) {
        return tf.format(text); // Delegates to the wrapped formatter
    }
}

// BoldTextFormatter adds bold formatting
class BoldTextFormatter extends Decorator {
    public BoldTextFormatter(TextFormatter tf) {
        super(tf);
    }

    public String format(String text) {
        return "<b>" + tf.format(text) + "</b>";
    }
}

// ItalicTextFormatter adds italic formatting
class ItalicTextFormatter extends Decorator {
    public ItalicTextFormatter(TextFormatter tf) {
        super(tf);
    }

    public String format(String text) {
        return "<i>" + tf.format(text) + "</i>";
    }
}

// UnderlineTextFormatter adds underline formatting
class UnderlineTextFormatter extends Decorator {
    public UnderlineTextFormatter(TextFormatter tf) {
        super(tf);
    }

    public String format(String text) {
        return "<u>" + tf.format(text) + "</u>";
    }
}

// Example usage
public class Application {
    public static void main(String[] args) {
        TextFormatter plain = new PlainTextFormatter();
        TextFormatter bold = new BoldTextFormatter(plain);
        TextFormatter italic = new ItalicTextFormatter(bold);
        TextFormatter underline = new UnderlineTextFormatter(italic);

        String result = underline.format("Hello, World!");
        System.out.println(result); // Output: <u><i><b>Hello, World!</b></i></u>
    }
}
