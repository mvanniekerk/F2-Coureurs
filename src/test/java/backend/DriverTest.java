package backend;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DriverTest {

    @Test
    public void constructorTest(){
        Driver driver = new Driver("Kimi Raikkonen", 16, 50, 50, 50, false);

        assertTrue(driver.getName().equals("Kimi Raikkonen"));
        assertTrue(driver.getSalary() == 16);
    }
}
