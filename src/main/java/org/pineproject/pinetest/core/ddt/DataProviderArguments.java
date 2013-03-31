package org.pineproject.pinetest.core.ddt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 31.03.13
 * Time: 21:27
 * BasedOn: http://www.lysergicjava.com/?p=165
 */

/**
 * Annotation for feeding arguments to methods conforming to the
 * "@DataProvider" annotation type.
 * @author jharen
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderArguments {
    /**
     * String array of key-value pairs fed to a dynamic data provider.
     * Should be in the form of key=value, e.g., <br />
     * args={"foo=bar", "biz=baz"}
     */

    String[] value();

}
