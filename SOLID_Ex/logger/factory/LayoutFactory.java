package SOLID_Ex.logger.factory;

import SOLID_Ex.logger.factory.interfaceF.Factory;
import SOLID_Ex.logger.layouts.interfaceL.Layout;
import SOLID_Ex.logger.layouts.SimpleLayout;
import SOLID_Ex.logger.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {

    @Override
    public Layout produce(String info) {
        Layout layout = null;

        if (info.equals("SimpleLayout")) {
            layout = new SimpleLayout();
        } else {
            layout = new XmlLayout();
        }

        return layout;
    }
}
