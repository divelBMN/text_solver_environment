package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Sensor {

    private SensorDictionary sensorType;
    private Float value;

    public boolean isEqual(Sensor sensor) {

        return this.sensorType == sensor.getSensorType() &&
                this.value != null &&
                value != null &&
                this.value.floatValue() == sensor.getValue().floatValue();
    }
}
