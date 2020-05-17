package com.itech.ups.base.web.taglibs.code;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author mike chen
 */
public final class PropertiesCodes implements Codes {

    private static final long serialVersionUID = -1280155952292176047L;

    private Properties properties = new Properties();

    public PropertiesCodes(String propertiesLocation) {

        InputStream resourceAsStream = PropertiesCodes.class.getResourceAsStream(propertiesLocation);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Code getCode(String name) {
        Code code = new Code(name);
        String content = (String) properties.get(name);
        if (content != null && !content.equals("")) {
            String[] values = content.split(";");
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null && !values[i].equals("")) {
                    String value = values[i].split(":")[0];
                    String label = values[i].split(":")[1];
                    code.addItem(value, label);
                }
            }
        }

        return code;
    }

}
