package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Action;
import divelbmn.text_solver_environment.Environment.dictionary.ActionDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionDtoTest {

    @Test
    public void testMakeAction() {

        ActionDto actionDto = new ActionDto("gotoItem");
        Action action = actionDto.makeAction();

        assertEquals(action.getAction(), ActionDictionary.GOTO_ITEM);
    }
}