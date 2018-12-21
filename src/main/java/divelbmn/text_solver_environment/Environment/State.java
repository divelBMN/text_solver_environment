package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor @AllArgsConstructor
@Getter
public class State {

    private Map<SensorDictionary, Sensor> sensors = new HashMap<>();


    public State addSensor(Sensor sensor) {

        sensors.put(sensor.getSensorType(), sensor);

        return this;
    }

    public boolean hasSensor(Sensor sensor) {

        return sensors.containsKey(sensor.getSensorType()) &&
                sensors.get(sensor.getSensorType()).isEqual(sensor);
    }
}
