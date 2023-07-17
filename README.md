# devservices-reproducer

This project contains a simple reproducer with failing `@QuarkusTest` and dev mode when devservices are disabled (`quarkus.devservices.enabled=false`)


- clone this repo
- run `./gradlew check --info`
- observe the test failure

```
LambdaHandlerTest > testHandleRequest() FAILED
    java.lang.NullPointerException: Cannot invoke "io.quarkus.arc.ArcContainer.bean(String)" because "<local3>" is null
        at org.acme.MyService_ClientProxy.<init>(Unknown Source)
        at org.acme.MyService_Bean.proxy(Unknown Source)
        at org.acme.MyService_Bean.get(Unknown Source)
        at org.acme.MyService_Bean.get(Unknown Source)
        at org.acme.LambdaHandler_Bean.doCreate(Unknown Source)
        at org.acme.LambdaHandler_Bean.create(Unknown Source)
        at org.acme.LambdaHandler_Bean.create(Unknown Source)
        at io.quarkus.arc.impl.AbstractSharedContext.createInstanceHandle(AbstractSharedContext.java:113)
        at io.quarkus.arc.impl.AbstractSharedContext$1.get(AbstractSharedContext.java:37)
        at io.quarkus.arc.impl.AbstractSharedContext$1.get(AbstractSharedContext.java:34)
        at io.quarkus.arc.impl.LazyValue.get(LazyValue.java:26)
        at io.quarkus.arc.impl.ComputingCache.computeIfAbsent(ComputingCache.java:69)
        at io.quarkus.arc.impl.AbstractSharedContext.get(AbstractSharedContext.java:34)
        at io.quarkus.arc.impl.ClientProxies.getApplicationScopedDelegate(ClientProxies.java:21)
        at org.acme.LambdaHandler_ClientProxy.arc$delegate(Unknown Source)
        at org.acme.LambdaHandler_ClientProxy.handleRequest(Unknown Source)
        at org.acme.LambdaHandlerTest.testHandleRequest(LambdaHandlerTest.java:16)
```

or

- clone this repo
- run `quarkus dev`
- app will terminate immediately (**Aborting lambda poll loop: ending dev/test mode**)

```
2023-07-17 20:57:25,406 INFO  [io.quarkus] (Quarkus Main Thread) devservices-reproducer 1.0.0-SNAPSHOT on JVM (powered by Quarkus 3.2.0.Final) started in 0.798s. 

2023-07-17 20:57:25,410 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2023-07-17 20:57:25,411 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [amazon-lambda, cdi]
2023-07-17 20:57:25,417 WARN  [io.qua.ama.lam.run.AbstractLambdaPollLoop] (Lambda Thread (DEVELOPMENT)) Aborting lambda poll loop: ending dev/test mode
2023-07-17 20:57:25,421 INFO  [io.quarkus] (Lambda Thread (DEVELOPMENT)) devservices-reproducer stopped in 0.003s

```