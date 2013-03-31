package org.pineproject.pinetest.dataproviders;

import org.pineproject.yaf.ddt.DataProviderUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ayia
 * Date: 31.03.13
 * Time: 22:43
 */
public class CommonDataProvider {

    @DataProvider
    public Object[][] commonData(Method testMethod) throws Exception {
        Map<String, String> arguments = DataProviderUtils.resolveDataProviderArguments(testMethod);
        Object[][] data = new Object[][]{{}};

        return data;
    }
}
