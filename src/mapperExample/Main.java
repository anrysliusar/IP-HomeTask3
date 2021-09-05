package mapperExample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User car = new User("Vasyl", "vasyl@gmail.com", 22);
        UserDTO userDTO = CustomMapper.map(car, UserDTO.class);
        System.out.println(userDTO);

    }
}
