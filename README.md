The following Environment Variable have to be set for user assigned identity to access key vault.
By default the key **testKey** will be loaded from the Key Vault and printed in **/key** endpoint

````
APPLICATIONINSIGHTS_CONNECTION_STRING=InstrumentationnKey...
SPRING_CLOUD_AZURE_KEYVAULT_SECRET_PROPERTYSOURCES_0_CREDENTIAL_CLIENTID=<uai-clientd>
SPRING_CLOUD_AZURE_KEYVAULT_SECRET_PROPERTYSOURCES_0_CREDENTIAL_MANAGEDIDENTITYENABLED=true
SPRING_CLOUD_AZURE_KEYVAULT_SECRET_PROPERTYSOURCES_0_PROFILE_TENANTID=<tenantid>
SPRING_CLOUD_AZURE_KEYVAULT_SECRET_PROPERTYSOURCEENABLED=true
SPRING_CLOUD_AZURE_KEYVAULT_SECRET_PROPERTYSOURCES_0_ENDPOINT=https://my-kv-endpoint
````

Throws the following exception in container apps:

````
8/5/2022, 7:03:26.363 PM,"        at io.opentelemetry.javaagent.shaded.instrumentation.reactor.TracingSubscriber.lambda$onNext$1(TracingSubscriber.java:58)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)"
8/5/2022, 7:03:26.363 PM,"        at io.opentelemetry.javaagent.shaded.instrumentation.reactor.TracingSubscriber.onNext(TracingSubscriber.java:58)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.core.util.paging.ContinuablePagedByPageIterable.iterator(ContinuablePagedByPageIterable.java:41)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:64)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultEnvironmentPostProcessor.buildKeyVaultPropertySource(KeyVaultEnvironmentPostProcessor.java:127)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoDelaySubscription.accept(MonoDelaySubscription.java:53)"
8/5/2022, 7:03:26.363 PM,"Caused by: java.io.IOException: Server returned HTTP response code: 400 for URL: http://localhost:42356/msi/token?resource=https%3A%2F%2Fvault.azure.net&api-version=2019-08-01&client_id=xxxxx"       
8/5/2022, 7:03:26.363 PM,"        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1520)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.InternalMonoOperator.subscribe(InternalMonoOperator.java:64)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:120)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.lang.Thread.run(Thread.java:829)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.lang.reflect.Method.invoke(Method.java:566)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.FluxDelaySubscription$DelaySubscriptionOtherSubscriber.onNext(FluxDelaySubscription.java:131)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoDelay$MonoDelayRunnable.run(MonoDelay.java:286)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoDelay$MonoDelayRunnable.propagateDelay(MonoDelay.java:271)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:114)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.core.util.paging.ContinuablePagedByIteratorBase.requestPage(ContinuablePagedByIteratorBase.java:94)"
8/5/2022, 7:03:26.363 PM,"        ... 27 common frames omitted"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplication.prepareEnvironment(SpringApplication.java:339)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultEnvironmentPostProcessor.buildKeyVaultPropertySource(KeyVaultEnvironmentPostProcessor.java:130)"
8/5/2022, 7:03:26.363 PM,"        Suppressed: java.lang.Exception: #block terminated with an error"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultOperation.<init>(KeyVaultOperation.java:77)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoCallable.subscribe(MonoCallable.java:57)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.env.EnvironmentPostProcessorApplicationListener.onApplicationEnvironmentPreparedEvent(EnvironmentPostProcessorApplicationListener.java:102)"
8/5/2022, 7:03:26.363 PM,"        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultOperation.refreshProperties(KeyVaultOperation.java:140)"
8/5/2022, 7:03:26.363 PM,"       
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultOperation.lambda$refreshProperties$2(KeyVaultOperation.java:140)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.context.event.EventPublishingRunListener.environmentPrepared(EventPublishingRunListener.java:85)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.identity.implementation.IdentityClient.lambda$authenticateToManagedIdentityEndpoint$55(IdentityClient.java:1322)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoDefer.subscribe(MonoDefer.java:52)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplication.run(SpringApplication.java:297)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1312)"
8/5/2022, 7:03:26.363 PM,"Caused by: reactor.core.Exceptions$ReactiveException: java.io.IOException: Server returned HTTP response code: 400 for URL: http://localhost:42356/msi/token?resource=https%3A%2F%2Fvault.azure.net&api-version=2019-08-01&client_id=XXXXX"    
8/5/2022, 7:03:26.363 PM,"       
8/5/2022, 7:03:26.363 PM,"        at java.base/java.lang.Iterable.spliterator(Iterable.java:101)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.env.EnvironmentPostProcessorApplicationListener.onApplicationEvent(EnvironmentPostProcessorApplicationListener.java:87)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultEnvironmentPostProcessor.postProcessEnvironment(KeyVaultEnvironmentPostProcessor.java:86)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1301)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.Exceptions.propagate(Exceptions.java:392)"
8/5/2022, 7:03:26.363 PM,"19:03:24.268 [main] ERROR org.springframework.boot.SpringApplication - Application run failed"  
8/5/2022, 7:03:26.363 PM,"        at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:28)"
8/5/2022, 7:03:26.363 PM,"        at com.example.demo.DemoApplicationKt.main(DemoApplication.kt:13)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)"
8/5/2022, 7:03:26.363 PM,"        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.MonoDelaySubscription.accept(MonoDelaySubscription.java:34)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplicationRunListeners.environmentPrepared(SpringApplicationRunListeners.java:65)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.spring.cloud.autoconfigure.keyvault.environment.KeyVaultEnvironmentPostProcessor.buildKeyVaultPropertySourceList(KeyVaultEnvironmentPostProcessor.java:115)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:97)"
8/5/2022, 7:03:26.363 PM,"        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)"
8/5/2022, 7:03:26.363 PM,"        at com.azure.core.util.paging.ContinuablePagedByPageIterable$ContinuablePagedByPageIterator.<init>(ContinuablePagedByPageIterable.java:54)"
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.Optional.map(Optional.java:265)"
8/5/2022, 7:03:26.363 PM,"java.lang.IllegalStateException: Failed to configure KeyVault property source"             
8/5/2022, 7:03:26.363 PM,"        at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.scheduler.SchedulerTask.call(SchedulerTask.java:68)"
8/5/2022, 7:03:26.363 PM,"        at reactor.core.publisher.Flux.blockLast(Flux.java:2645)"
8/5/2022, 7:03:26.363 PM,"        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1924)"
8/5/2022, 7:03:26.363 PM,"        at org.springframework.boot.SpringApplicationRunListeners.lambda$environmentPrepared$2(SpringApplicationRunListeners.java:66)"
8/5/2022, 7:03:26.363 PM,"        at io.opentelemetry.javaagent.shaded.instrumentation.reactor.TracingSubscriber.withActiveSpan(TracingSubscriber.java:79)"
````
