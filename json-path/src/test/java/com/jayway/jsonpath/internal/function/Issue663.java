package com.jayway.jsonpath.internal.function;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Issue663 {
    @Test
    public void testJsonPathCacheWithSumFunction() {
        String jsonString = "{\r\n"
                + "\"total\":1,\r\n"
                + "\"data\":[\r\n"
                + " {\r\n"
                + "\"client_count\":358\r\n"
                + " }\r\n"
                + " ]\r\n"
                + "}";
        double value1 = JsonPath.read(jsonString, "$.sum($..client_count)");
        assertEquals(358, value1, 0);

        String jsonString2 = "{\r\n"
                + "\"total\":1,\r\n"
                + "\"data\":[\r\n"
                + " {\r\n"
                + "\"client_count\":308\r\n"
                + " }\r\n"
                + " ]\r\n"
                + "}";
        double value2 = JsonPath.read(jsonString2, "$.sum($..client_count)");
        assertEquals(308, value2, 0);
    }

    @Test
    public void testJsonPathCacheWithMaxFunction() {
        String jsonString = "{\r\n"
                + "\"total\":1,\r\n"
                + "\"data\":[\r\n"
                + " {\r\n"
                + "\"client_count\":358\r\n"
                + " }\r\n"
                + " ]\r\n"
                + "}";
        double value1 = JsonPath.read(jsonString, "$.max($..client_count)");
        assertEquals(358, value1, 0);

        String jsonString2 = "{\r\n"
                + "\"total\":1,\r\n"
                + "\"data\":[\r\n"
                + " {\r\n"
                + "\"client_count\":308\r\n"
                + " }\r\n"
                + " ]\r\n"
                + "}";
        double value2 = JsonPath.read(jsonString2, "$.max($..client_count)");
        assertEquals(308, value2, 0);
    }
}
