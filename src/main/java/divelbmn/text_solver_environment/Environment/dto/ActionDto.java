package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Action;
import divelbmn.text_solver_environment.Environment.dictionary.ActionDictionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActionDto {

    private String type;


    public Action makeAction() {
        return new Action(ActionDictionary.valueOf(type));
    }
}
