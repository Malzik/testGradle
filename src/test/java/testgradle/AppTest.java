package testgradle;

import junit.framework.TestCase;
import org.apache.commons.math3.distribution.NormalDistribution;

public class AppTest extends TestCase {
    private NormalDistribution n;
    private App app;

    @Override
    public void setUp() throws Exception {
        n = new NormalDistribution();
        app = new App();
    }

    public void testCovidChanceEnMoyenne() {
        double response = app.covidChanceEnMoyenne(n, 5);

        assertEquals(0.99, response, 0.1);
    }

    public void testCovidChanceDurree() {
        double response = app.covidChanceDurree(n, -6, 29);

        assertEquals(0.99, response, 0.1);
    }
}