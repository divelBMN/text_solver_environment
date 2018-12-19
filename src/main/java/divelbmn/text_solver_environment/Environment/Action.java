package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.ActionDictionary;
import divelbmn.text_solver_environment.Environment.executor.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Action {

    private ActionDictionary action;


    public ActionExecutor getExecutor() {

        switch (action) {
            case GOTO_ITEM: return new GotoItemAction();
            case GOTO_OWNER: return new GotoOwnerAction();
            case PICKUP_ITEM: return new PickupItemAction();
            case GIVE_ITEM: return new GiveItemAction();
        }

        return null;
    }
}
