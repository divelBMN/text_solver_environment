package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SensorDto {

    private String name;
    private Float value;


    public SensorDto(Sensor sensor) {
        name = sensor.getSensorType().getSensorType();
    }


    public Sensor makeSensor() {
        return new Sensor(SensorDictionary.valueOf(name), value);
    }
}
