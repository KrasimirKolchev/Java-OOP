package SOLID_Ex.logger.factory;

import SOLID_Ex.logger.appenders.ConsoleAppender;
import SOLID_Ex.logger.Enum.ErrorTypes;
import SOLID_Ex.logger.appenders.FileAppender;
import SOLID_Ex.logger.appenders.LogFile;
import SOLID_Ex.logger.appenders.interfaces.Appender;
import SOLID_Ex.logger.factory.interfaceF.Factory;
import SOLID_Ex.logger.layouts.interfaceL.Layout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppenderFactory implements Factory<Appender> {
    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String info) throws IOException {
        String[] data = info.split("\\s+");

        String appenderType = data[0];
        String layoutType = data[1];

        Layout layout = this.layoutFactory.produce(layoutType);

        Appender appender = null;

        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else {
            appender = new FileAppender(layout);
            Path path = Paths.get(LogFile.getFilePath());
            Files.createDirectories(path.getParent());
            if(!Files.exists(path))
                Files.createFile(path);

        }

        if (data.length == 3) {
            appender.setErrorTypes(ErrorTypes.valueOf(data[2]));
        }

        return appender;
    }
}
