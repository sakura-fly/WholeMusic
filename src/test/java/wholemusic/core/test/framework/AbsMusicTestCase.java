package wholemusic.core.test.framework;

/**
 * Test implements base class
 */
public abstract class AbsMusicTestCase {
    public abstract void init(Object[] args);

    public abstract void runTest() throws Exception;

    protected void println(String message) {
        System.out.println(combine(message));
    }

    private String combine(String message) {
        return "[" + this.getClass().getSimpleName() + "] " + message;
    }

    protected void errPrintln(String message) {
        System.err.println(combine(message));
    }
}
