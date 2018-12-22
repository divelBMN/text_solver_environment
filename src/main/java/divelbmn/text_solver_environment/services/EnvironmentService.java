package divelbmn.text_solver_environment.services;

import divelbmn.text_solver_environment.Environment.dto.ReactionRequestDto;
import divelbmn.text_solver_environment.Environment.dto.StateDto;
import org.springframework.stereotype.Service;

@Service
public interface EnvironmentService {

    StateDto doAction(ReactionRequestDto reactionRequestDto);
}
