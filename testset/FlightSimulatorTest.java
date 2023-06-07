import static org.junit.Assert.*;

import org.junit.Test;

public class FlightSimulatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testPlanesNull() {
        FlightSimulator.simulateFlights(null, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStepsZero() {
        Airplane plane1 = new Airplane(1, 1, 0, 1);
        Airplane[] planes = new Airplane[1];
        planes[0] = plane1;
        FlightSimulator.simulateFlights(planes, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOnePlaneNull() {
        Airplane plane1 = null;
        Airplane plane2 = new Airplane(3, 1, 180, 1);
        Airplane[] planes = new Airplane[2];
        planes[0] = plane1;
        planes[1] = plane2;
        FlightSimulator.simulateFlights(planes, 2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlanesNullAndSafeDistanceNegative() {
        FlightSimulator.simulateFlights(null, 5, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVelocityNegative() {
        Airplane plane1 = new Airplane(1, 1, 0, -1);
        Airplane[] planes = new Airplane[1];
        planes[0] = plane1;
        FlightSimulator.simulateFlights(planes, 2, 1);
    }

    @Test
    public void testTwoPlanes() {
        Airplane plane1 = new Airplane(1, 1, 0, 2);
        Airplane plane2 = new Airplane(3, 1, 180, 1);
        Airplane[] planes = new Airplane[2];
        planes[0] = plane1;
        planes[1] = plane2;
        assertFalse(FlightSimulator.simulateFlights(planes, 2, 1));
    }

    @Test
    public void testBearingLarge() {
        Airplane plane1 = new Airplane(0, 0, 1800, 1);
        Airplane plane2 = new Airplane(3, 1, 180, 1);
        Airplane[] planes = new Airplane[2];
        planes[0] = plane1;
        planes[1] = plane2;
        assertTrue(FlightSimulator.simulateFlights(planes, 2, 1));
    }

    @Test
    public void testMoveVertically() {
        Airplane plane1 = new Airplane(0, 0, 90, 1);
        Airplane plane2 = new Airplane(0, 3, 270, 1);
        Airplane[] planes = new Airplane[2];
        planes[0] = plane1;
        planes[1] = plane2;
        assertFalse(FlightSimulator.simulateFlights(planes, 2, 1));
    }

    @Test
    public void testFalseInSecondStep() {
        Airplane plane1 = new Airplane(0, 0, 0, 1);
        Airplane plane2 = new Airplane(4, 0, 180, 1);
        Airplane[] planes = new Airplane[2];
        planes[0] = plane1;
        planes[1] = plane2;
        assertFalse(FlightSimulator.simulateFlights(planes, 2, 1));
    }


}
