package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class PickupItemActionTest {

    private final Float VALUE = 1f;


    @Test
    public void testDoAction() {

        ActionExecutor executor = new PickupItemAction();

        State correctResult = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
        State wrongResult = executor.doAction(new State()
                .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        assertFalse(wrongResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
    }
}