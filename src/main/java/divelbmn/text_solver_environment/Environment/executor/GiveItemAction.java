package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;

public class GiveItemAction implements ActionExecutor {

    private final Float ACTION_VALUE = 1f;
    private final Float ACTION_ZERO_VALUE = 0f;


    @Override
    public State doAction(State start) {

        if (start.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ACTION_VALUE)) &&
                start.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, ACTION_VALUE))) {

            return start
                    .addSensor(new Sensor(SensorDictionary.HAS_ITEM, ACTION_ZERO_VALUE))
                    .addSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, ACTION_VALUE));
        }

        return start;
    }
}
