package divelbmn.text_solver_environment.Environment;

public class Environment {

    public State doAction(State start, Action action) {

        ActionExecutor executor = selectExecutor(action);

        return executor.doAction(start);
    }
}
