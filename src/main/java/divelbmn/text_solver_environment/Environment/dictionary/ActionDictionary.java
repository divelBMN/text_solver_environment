package divelbmn.text_solver_environment.Environment.dictionary;

public enum ActionDictionary {
    GOTO_ITEM ("gotoItem"),
    GOTO_OWNER ("gotoOwner"),
    PICKUP_ITEM ("pickupItem"),
    GIVE_ITEM ("giveItem");

    private String actionType;


    ActionDictionary(String actionType) {
        this.actionType = actionType;
    }
}
