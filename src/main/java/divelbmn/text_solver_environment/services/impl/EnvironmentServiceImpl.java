package divelbmn.text_solver_environment.services.impl;

import divelbmn.text_solver_environment.Environment.Action;
import divelbmn.text_solver_environment.Environment.Environment;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dto.ReactionRequestDto;
import divelbmn.text_solver_environment.Environment.dto.StateDto;
import divelbmn.text_solver_environment.services.EnvironmentService;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Override
    public StateDto doAction(ReactionRequestDto reactionRequestDto) {

        State start = reactionRequestDto.makeState();
        Action action = reactionRequestDto.makeAction();

        Environment environment = new Environment();
        State result =  environment.doAction(start, action);

        return new StateDto(result);
    }
}
