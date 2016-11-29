package backend;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DriverTest {

    private Driver driver;

    @Before
    public void setUp() {
        driver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);
    }

    @Test
    public void constructorTest_name() {
        assertTrue(driver.getName().equals("Kimi Raikkonen"));
    }

    @Test
    public void constructorTest_salary() {
        assertTrue(driver.getSalary() == 16);
    }
}