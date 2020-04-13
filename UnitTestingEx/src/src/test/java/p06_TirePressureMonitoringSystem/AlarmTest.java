package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class AlarmTest {

    @Test
    public void ifPressureIsInRangeAlarmShouldBeFalse() {

    }

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();
        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        fieldSensor.set(alarm, sensor);

        Assert.assertFalse(alarm.getAlarmOn());
    }
}