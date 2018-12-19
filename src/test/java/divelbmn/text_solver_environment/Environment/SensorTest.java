package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SensorTest {

    private final Float VALUE = 1f;
    private final Float ZERO_VALUE = 0f;

    Sensor originalSensor;


    @Before
    public void init() {
        originalSensor = new Sensor(SensorDictionary.HAS_ITEM, VALUE);
    }


    @Test
    public void testSensorIsEqual() {

        assertTrue(originalSensor.isEqual(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
    }

    @Test
    public void testSensorIsEqual_wrong() {

        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.NEAR_ITEM, ZERO_VALUE)));

        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.NEAR_OWNER, ZERO_VALUE)));

        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)));
        assertFalse(originalSensor.isEqual(new Sensor(SensorDictionary.OWNER_HAS_ITEM, ZERO_VALUE)));
    }
}