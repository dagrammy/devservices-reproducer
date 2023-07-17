package org.acme;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Map;
import org.jboss.logging.Logger;

@Named("TestHandler")
@ApplicationScoped
public class LambdaHandler implements RequestHandler<Map, String> {

  private static final Logger LOG = Logger.getLogger(LambdaHandler.class);

  private final MyService myService;

  @Inject
  public LambdaHandler(MyService myService) {
    this.myService = myService;
  }

  @Override
  public String handleRequest(Map input, Context context) {
    LOG.info("handleRequest and say hello");
    return myService.sayHello();
  }
}
