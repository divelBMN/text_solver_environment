package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;

public class GotoOwnerAction implements ActionExecutor {

    private final Float ACTION_VALUE = 1f;


    @Override
    public State doAction(State start) {

        return new State()
                .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, ACTION_VALUE));
    }
}
