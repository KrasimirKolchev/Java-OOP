package SOLID_Ex.logger;

import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.appenders.interfaces.Appender;
import SOLID_Ex.logger.factory.AppenderFactory;
import SOLID_Ex.logger.loggers.MessageLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** В случай, че не може да бъде създаден файлът в избраната директория със exception :
 * "Exception in thread "main" java.nio.file.AccessDeniedException: C:\Users\Public\test.txt"
 * моля променете в клас LogFile полето FILE_PATH с избран от вас нов FILE_PATH.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Appender[] appenders = new Appender[n];

        for (int i = 0; i < n; i++) {

            String input = reader.readLine();
            Appender appender = new AppenderFactory().produce(input);
            appenders[i] = appender;
        }

        MessageLogger logger = new MessageLogger(appenders);

        String command;
        while (!"END".equals(command = reader.readLine())) {
            String[] data = command.split("\\|");
            String errorType = data[0];
            String date = data[1];
            String message = data[2];

            switch (ErrorTypes.valueOf(errorType)) {
                case INFO:
                    logger.logInfo(date, message);
                    break;
                case WARNING:
                    logger.logWarning(date, message);
                    break;
                case ERROR:
                    logger.logError(date, message);
                    break;
                case FATAL:
                    logger.logFatal(date, message);
                    break;
                case CRITICAL:
                    logger.logCritical(date, message);
                    break;
            }
        }

        System.out.println(logger.toString());

    }
}
