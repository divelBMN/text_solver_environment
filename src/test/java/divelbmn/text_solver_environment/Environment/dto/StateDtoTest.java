package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.State;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StateDtoTest {

    private static final Float VALUE = 1f;


    @Test
    public void testMakeStateDto() {

        State state = new State().addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE));
        StateDto stateDto = new StateDto(state);

        assertEquals("hasItem", stateDto.getSensors().get(0).getName());
        assertEquals(stateDto.getSensors().get(0).getValue(), VALUE);
    }

    @Test
    public void testMakeState() {

        StateDto stateDto = new StateDto( Arrays.asList(new SensorDto("hasItem", VALUE)));
        State state = stateDto.makeState();

        assertTrue(state.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
    }
}