package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Action;
import divelbmn.text_solver_environment.Environment.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReactionRequestDto {

    private StateDto start;
    private ActionDto action;


    public State makeStart() {

        State startState = new State();
        start.getSensors().forEach(sensorDto -> startState.addSensor(sensorDto.makeSensor()));

        return startState;
    }

    public Action makeAction() {
        return action.makeAction();
    }
}
