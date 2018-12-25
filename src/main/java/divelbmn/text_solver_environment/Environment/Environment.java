package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.executor.*;

public class Environment {

    public State doAction(State start, Action action) {

        Reactor executor = action.getExecutor();
        if (executor == null) {

            return start;
        }

        return executor.doAction(start);
    }
}
