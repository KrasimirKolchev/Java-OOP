package solidLab.p05_DependencyInversion.p01_HelloWord;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR);

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.greeting("name", hour));
    }
}
