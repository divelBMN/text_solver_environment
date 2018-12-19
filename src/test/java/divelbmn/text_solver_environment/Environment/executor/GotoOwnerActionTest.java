package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class GotoOwnerActionTest {

    private final Float VALUE = 1f;


    @Test
    public void testDoAction() {

        ActionExecutor executor = new GotoOwnerAction();

        State correctResult = executor.doAction(new State());

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
    }
}