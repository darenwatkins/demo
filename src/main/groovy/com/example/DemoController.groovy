package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType
import io.micronaut.core.annotation.Introspected
import groovy.transform.TupleConstructor

@Controller("/demo")
class DemoController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    String index() {
        "Example Response"
    }

    @Post
    SampleReturnMessage postMethod(@Body SampleInputMessage inputMessage){
      new SampleReturnMessage(returnMessage: "Hello ${inputMessage.name}, thank you for sending the message")
    }
}

@TupleConstructor
@Introspected
class SampleInputMessage{
    String name
}

@Introspected
class SampleReturnMessage{
    String returnMessage
}
