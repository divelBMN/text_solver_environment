package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class GotoItemActionTest {

    private final Float VALUE = 1f;


    @Test
    public void testDoAction() {

        ActionExecutor executor = new GotoItemAction();

        State correctResult = executor.doAction(new State());

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
    }
}