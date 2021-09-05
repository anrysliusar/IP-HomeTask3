package mapperExample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CustomMapper {
    public static <E, T> T map(E o, Class<T> dtoClazz ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Field[] dtoFields = findDeclaredFields(dtoClazz);
        Field[] objFields = findDeclaredFields(o.getClass());

        T newInstance = dtoClazz.getDeclaredConstructor().newInstance();
        for (Field dtoField : dtoFields) {
            for (Field objField : objFields) {
                //Check if these fields are compatible
                if(getFieldName(dtoField).equals(getFieldName(objField)) && objField.getType() == dtoField.getType()){
                    CheckRangeAnnotationAndSet(o, objField, dtoField, newInstance);
                    }
                }
            }
        return newInstance;
    }

    public static <E, T> void CheckRangeAnnotationAndSet(E o, Field objField, Field dtoField, T instance) throws IllegalAccessException {
        if (objField.isAnnotationPresent(Range.class)) {
            int min = objField.getAnnotation(Range.class).min();
            int max = objField.getAnnotation(Range.class).max();
            if (min <= (int) objField.get(o) && max >= (int) objField.get(o)) {
                dtoField.set(instance, objField.get(o));
            } else
                throw new IllegalArgumentException(String.format("%s must be >= %d and <= %d", objField.getName(), min, max));
        } else{
            dtoField.set(instance, objField.get(o));
        }

    }

    public static String getFieldName(Field field) {
        return field.getName().toLowerCase();
    }

    public static <E> Field[] findDeclaredFields(Class<E> clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> field.setAccessible(true));
        return declaredFields;
    }
}
