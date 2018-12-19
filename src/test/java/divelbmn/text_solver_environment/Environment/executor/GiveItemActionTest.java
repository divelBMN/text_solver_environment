package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiveItemActionTest {

    private final Float VALUE = 1f;
    private final Float ZERO_VALUE = 0f;


    @Test
    public void testDoAction() {

        ActionExecutor executor = new GiveItemAction();

        State correctResult = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE))
                .addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        State wrongResult_one = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
        State wrongResult_two = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        State wrongResult_three = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));

        assertFalse(wrongResult_one.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                wrongResult_one.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
        assertFalse(wrongResult_two.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                wrongResult_two.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
        assertFalse(wrongResult_three.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                wrongResult_three.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
    }
}