package divelbmn.text_solver_environment.Environment.dto;

import divelbmn.text_solver_environment.Environment.Sensor;
import divelbmn.text_solver_environment.Environment.dictionary.SensorDictionary;
import org.junit.Test;

import static org.junit.Assert.*;

public class SensorDtoTest {

    private final Float VALUE = 1f;
    private final float DELTA = .000001f;


    @Test
    public void testMakeSensorDto() {

        Sensor sensor = new Sensor(SensorDictionary.HAS_ITEM, VALUE);
        SensorDto sensorDto = new SensorDto(sensor);

        assertEquals("hasItem", sensorDto.getName());
        assertEquals(sensorDto.getValue(), VALUE, DELTA);
    }

    @Test
    public void testMakeSensor() {

        SensorDto sensorDto = new SensorDto("hasItem", VALUE);
        Sensor sensor = sensorDto.makeSensor();

        assertEquals(sensor.getSensorType(), SensorDictionary.HAS_ITEM);
        assertEquals(sensor.getValue(), VALUE, DELTA);
    }
}