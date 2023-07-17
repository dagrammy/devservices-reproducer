package org.acme;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
class LambdaHandlerTest {

  @Inject
  LambdaHandler lambdaHandler;

  @Test
  void testHandleRequest() {
    lambdaHandler.handleRequest(null, null);
  }

}