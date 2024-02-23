package com.ltrsoft.userpoliceapp.helper;
import com.ltrsoft.userpoliceapp.interfaces.ErrorListener;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ObjToMap {
    public static HashMap<String, String> convertObjectToHashMap(Object obj, ErrorListener listener) {
        HashMap<String, String> map = new HashMap<>();

        // Get all declared fields of the object's class
        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            // Iterate through the fields
            for (Field field : fields) {
                // Allow access to private fields
                field.setAccessible(true);
                // Get the field value from the object
                Object value = field.get(obj);

                // Put the field name and value into the map
                map.put(field.getName(), (String) value);
            }
        } catch (IllegalAccessException e) {
            listener.Error(e.toString());
            System.out.println("error"+e.toString());
            e.printStackTrace();
        }
        return map;
    }

}
