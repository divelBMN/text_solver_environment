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


    public static ActionDictionary getActionDictionary(String type) {

        for (ActionDictionary actionDictionary : values()) {
            if (actionDictionary.actionType.equals(type)) {

                return actionDictionary;
            }
        }

        return null;
    }
}
