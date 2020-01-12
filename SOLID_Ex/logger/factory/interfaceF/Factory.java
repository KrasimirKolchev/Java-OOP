package SOLID_Ex.logger.factory.interfaceF;

import java.io.IOException;

public interface Factory<T> {
    T produce(String info) throws IOException;
}
