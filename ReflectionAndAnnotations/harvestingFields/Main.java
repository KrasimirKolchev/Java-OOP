package ReflectionAndAnnotations.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		String command;
		while (!"HARVEST".equals(command = reader.readLine())) {

			switch (command) {
				case "public" :
					for (Field field : fields) {
						if (Modifier.isPublic(field.getModifiers())) {
							System.out.println(String.format("%s %s %s"
									, Modifier.toString(field.getModifiers())
									, field.getGenericType().getTypeName()
											.substring(field.getGenericType().getTypeName().lastIndexOf('.') + 1)
									, field.getName()));
						}
					}
					break;
				case "protected" :
					for (Field field : fields) {
						if (Modifier.isProtected(field.getModifiers())) {
							System.out.println(String.format("%s %s %s"
									, Modifier.toString(field.getModifiers())
									, field.getGenericType().getTypeName()
											.substring(field.getGenericType().getTypeName().lastIndexOf('.') + 1)
									, field.getName()));
						}
					}
					break;
				case "private" :
					for (Field field : fields) {
						if (Modifier.isPrivate(field.getModifiers())) {
							System.out.println(String.format("%s %s %s"
									, Modifier.toString(field.getModifiers())
									, field.getGenericType().getTypeName()
											.substring(field.getGenericType().getTypeName().lastIndexOf('.') + 1)
									, field.getName()));
						}
					}
					break;
				case "all" :
					for (Field field : fields) {
						System.out.println(String.format("%s %s %s"
						, Modifier.toString(field.getModifiers())
						, field.getGenericType().getTypeName()
										.substring(field.getGenericType().getTypeName().lastIndexOf('.') + 1)
						, field.getName()));
					}
					break;
			}

		}

	}
}
