package ReflectionAndAnnotations.barracksWars.core.factories;

import ReflectionAndAnnotations.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotations.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		try {
			Class<? extends Unit> aClass = (Class<? extends Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor constr = aClass.getConstructor();
			unit = (Unit) constr.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException
				| InvocationTargetException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}

		return unit;
	}
}
