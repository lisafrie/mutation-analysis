import static org.junit.Assert.*;

import org.junit.Test;

public class FlightSimulatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPlanesNull() {
        FlightSimulator.simulateFlights(null, 0, 0);
    }

}
