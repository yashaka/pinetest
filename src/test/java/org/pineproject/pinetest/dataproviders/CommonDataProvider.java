package org.pineproject.pinetest.dataproviders;

import org.pineproject.pinetest.core.ddt.DataProviderUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 31.03.13
 * Time: 22:43
 */

/*
 * So far this is only a draft to use in future when needed. It serves  as an example to use DataProviderArguments
 */
public class CommonDataProvider {

    @DataProvider
    public static Object[][] commonPagesData(Method testMethod) throws Exception {
        Map<String, String> arguments = DataProviderUtils.resolveDataProviderArguments(testMethod);

        /*get needed arguments and process them here...*/

        /*populate data array with data according to passed arguments...*/
        Object[][] data = new Object[][]{
                {}
        };

        return data;
    }

}
