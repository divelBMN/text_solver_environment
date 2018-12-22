package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class StateDto {

    private List<SensorDto> sensors;


    public StateDto(State state) {
        sensors = state.getSensors().keySet().stream()
                .map(sensorKey -> new SensorDto(
                        sensorKey.getSensorType(),
                        state.getSensors().get(sensorKey).getValue()))
                .collect(Collectors.toList());
    }


    public State makeState() {
        State state = new State();
        sensors.forEach(sensorDto -> state.addSensor(sensorDto.makeSensor()));

        return state;
    }

    public boolean hasSensor(SensorDto expectedSensor) {

        List<SensorDto> findings = sensors.stream()
                .filter(checked ->
                        checked.getName().equals(expectedSensor.getName()) &&
                        checked.getValue().equals(expectedSensor.getValue()))
                .collect(Collectors.toList());

        return findings.size() > 0;
    }
}
