package ReflectionAndAnnotations.blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BlackBoxInt blackBox = null;

        try {
            Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            blackBox = (BlackBoxInt) constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] input = command.split("_");
            String commandName = input[0];
            int value = Integer.parseInt(input[1]);

            Method method = Arrays.stream(methods).filter(m -> m.getName()
                    .equals(commandName)).findFirst().orElse(null);

            method.setAccessible(true);

            try {
                method.invoke(blackBox, value);

                Field innerValue = blackBox.getClass().getDeclaredField("innerValue");
                innerValue.setAccessible(true);

                System.out.println(innerValue.getInt(blackBox));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
