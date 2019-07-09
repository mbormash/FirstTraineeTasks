import com.implemica.bormashenko.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for Main class.
 *
 * @author Mykhailo Bormashenko
 */
class MainClassTest {

    /**
     * Function for testing Main class.
     * Any exception should not be thrown.
     * @param args command line parameters.
     */
    private void check(String... args) {
        try {
            Main.main(args);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests for Main class.
     */
    @Test
    void test() {
        check();
        check("1");
        check("1", "2");
        check("1", "2", "3");
        check("1", "2", "3", "4");
        check("1", "2", "3", "4", "5");
    }
}
