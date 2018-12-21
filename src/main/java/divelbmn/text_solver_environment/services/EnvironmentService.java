package divelbmn.text_solver_environment.services;

import divelbmn.text_solver_environment.Environment.dto.ReactionRequestDto;
import divelbmn.text_solver_environment.Environment.dto.StateDto;

public interface EnvironmentService {

    StateDto doAction(ReactionRequestDto reactionRequestDto);
}
