# Payara Issue #5594
This is an example repository for Payara issue [#5549](https://github.com/payara/Payara/issues/5594). It defines a custom readiness check via a CDI extension. At application runtime, the CDI bean can be injected but is not included in the `GET /health`  or `GET /health/ready` APIs.

# Noteworthy Files
* `CdiExtension.java` adds a custom readiness check using the `AfterBeanDiscovery` event.
* `RestApi.java` defines an API that provides a list of all readiness check names.

# Running Project
This project can be run with the Payara Maven plugin.
```bash
mvn clean package payara-micro:start
```

# Testing
Two APIs are exposed.
1. `GET /health` is provided by Payara.
1. `GET /health-checks/readiness` is provided by this application. It includes a name for every injectable readiness check.

## Actual Behavior
In Payara 5.2021.10, `GET /health` does not include the custom health check. However `GET /health-checks/readiness` is able to find the custom health check as a CDI bean with the readiness qualifier.

## Expected Behavior
The `GET /health` API should include the custom health check.




