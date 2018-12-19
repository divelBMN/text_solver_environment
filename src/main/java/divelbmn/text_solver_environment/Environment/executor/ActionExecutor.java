package divelbmn.text_solver_environment.Environment.executor;

import divelbmn.text_solver_environment.Environment.State;

public interface ActionExecutor {

    State doAction(State start);
}
