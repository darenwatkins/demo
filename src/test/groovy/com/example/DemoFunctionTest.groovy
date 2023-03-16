package com.example;
import com.microsoft.azure.functions.HttpStatus
import io.micronaut.azure.function.http.HttpRequestMessageBuilder
import io.micronaut.http.HttpMethod
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoFunctionTest {

    @Test
    void testFunction() {
        new Function().withCloseable { Function function ->
            HttpRequestMessageBuilder.AzureHttpResponseMessage response =
                function.request(HttpMethod.GET, "/demo")
                        .invoke()
            assertEquals(HttpStatus.OK, response.status)
        }
    }
}
