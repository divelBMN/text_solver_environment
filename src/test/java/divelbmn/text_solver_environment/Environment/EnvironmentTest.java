package divelbmn.text_solver_environment.Environment;

import divelbmn.text_solver_environment.Environment.dictionary.ActionDictionary;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnvironmentTest {

    private final Float VALUE = 1f;
    private final Float ZERO_VALUE = 0f;

    private Environment environment;


    @Before
    public void init() {
        environment = new Environment();
    }

    @Test
    public void testGotoItem() {

        State correctResult = environment.doAction(new State(), new Action(ActionDictionary.GOTO_ITEM));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)));
    }

    @Test
    public void testGotoOwner() {

        State correctResult = environment.doAction(new State(), new Action(ActionDictionary.GOTO_OWNER));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)));
    }

    @Test
    public void testPickupItem() {

        State correctResult = environment.doAction(
                new State().addSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE)),
                new Action(ActionDictionary.PICKUP_ITEM));
        State wrongResult = environment.doAction(
                new State().addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)),
                new Action(ActionDictionary.PICKUP_ITEM));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
        assertFalse(wrongResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)));
    }

    @Test
    public void testGiveItem() {

        State correctResult = environment.doAction(
                new State()
                        .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE))
                        .addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)),
                new Action(ActionDictionary.GIVE_ITEM));
        State wrongResult_one = environment.doAction(
                new State()
                        .addSensor(new Sensor(SensorDictionary.NEAR_OWNER, VALUE)),
                new Action(ActionDictionary.GIVE_ITEM));
        State wrongResult_two = environment.doAction(
                new State()
                        .addSensor(new Sensor(SensorDictionary.NEAR_ITEM, VALUE))
                        .addSensor(new Sensor(SensorDictionary.HAS_ITEM, VALUE)),
                new Action(ActionDictionary.GIVE_ITEM));

        assertTrue(correctResult.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
        assertFalse(wrongResult_one.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
        assertFalse(wrongResult_two.hasSensor(new Sensor(SensorDictionary.OWNER_HAS_ITEM, VALUE)) &&
                correctResult.hasSensor(new Sensor(SensorDictionary.HAS_ITEM, ZERO_VALUE)));
    }
}