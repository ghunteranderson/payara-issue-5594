# Payara Issue #5594 / #6314
This is an example repository for Payara issue [#6314](https://github.com/payara/Payara/issues/6314) (previously [#5594](https://github.com/payara/Payara/issues/5594)). It defines a MicroProfile Health readiness check via a CDI extension. At runtime, the synthetic `HealthCheck` bean can be injected but is not included in the health check APIs.

# Noteworthy Files
* `CdiExtension.java` - defines a readiness check using CDI portable extensions
* `AnnotatedClassHealthCheck.java` - defines a readiness check using an annotated class
* `AnnotatedProducerHealthCheck.java` - defines readiness checks using field and method producers
* `BeansApi.java` - defines an API listing all `HealthCheck` beans

# Running Project
This project can be run with the Payara Maven plugin.
```bash
mvn clean package payara-micro:start
```

# Testing
These two APIs should be compared:
1. `GET /health` - MicroProfile Health API
1. `GET /beans/health-checks` Application API listing all `HealthCheck` beans

## Actual Behavior
In Payara 6.2023.6, the API `GET /health` does not include any health checks defined as synthetic beans.

## Expected Behavior
The `GET /health` API should include any health check bean (synthetic or otherwise)
