package divelbmn.text_solver_environment.api;

import divelbmn.text_solver_environment.Environment.dto.ReactionRequestDto;
import divelbmn.text_solver_environment.Environment.dto.StateDto;
import divelbmn.text_solver_environment.services.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
public class ApiEnvironmentController {

    private final EnvironmentService environmentService;

    @Autowired
    public ApiEnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }


    @PostMapping("/doAction")
    public StateDto doAction(@RequestBody ReactionRequestDto reactionRequestDto) {

        return environmentService.doAction(reactionRequestDto);
    }
}
