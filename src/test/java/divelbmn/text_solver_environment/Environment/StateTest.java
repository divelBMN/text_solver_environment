package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StateTest {

    private final Float VALUE = 1f;
    private final Float ZERO_VALUE = 0f;


    private State makeHasItemState() {

        Map<SensorDictionary, Sensor> sensors = new HashMap<>();
        sensors.put(SensorDictionary.HAS_ITEM, new Sensor(SensorDictionary.HAS_ITEM, VALUE));

        return new State(sensors);
    }

    @Test
    public void testHasSensor() {

        State state = makeHasItemState();

        assertTrue(state.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
    }

    @Test
    public void testHasSensor_wrong() {

        State state = makeHasItemState();

        assertFalse(state.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, ZERO_VALUE)));

        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_ITEM, ZERO_VALUE)));

        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, ZERO_VALUE)));
    }

    @Test
    public void testAddSensor() {

        State state = new State();

        state.addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE));

        assertTrue(state.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
        assertFalse(state.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
    }
}