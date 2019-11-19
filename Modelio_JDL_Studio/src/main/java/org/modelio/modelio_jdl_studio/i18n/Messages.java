package org.modelio.modelio_jdl_studio.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("93583c7f-c4ad-423f-b3db-052e1f401c20")
public class Messages {
    @objid ("38c1befa-4d8e-4ea0-b66e-2cfadc729b7f")
    private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle ("org.modelio.modelio_jdl_studio.i18n.messages");

    @objid ("556d6737-1ddf-48ed-8a85-3c87c8ea4ffc")
    private Messages() {
    }

    @objid ("8ac2342c-ce4f-4786-82c1-9111d4dacbcb")
    public static String getString(final String key) {
        try {
            return RESOURCE_BUNDLE.getString (key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    @objid ("ce0b0848-384b-4296-8b89-5a4107ef898e")
    public static String getString(final String key, final String... params) {
        try {
            return MessageFormat.format (RESOURCE_BUNDLE.getString (key),(Object[]) params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

}
