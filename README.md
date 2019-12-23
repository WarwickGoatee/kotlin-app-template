# Kotlin App Template

This is a repository to be used as a template for Kotlin applications. Batteries are included:
you get Warwick SSO authentication, roles/groups, masquerading, frontend asset compilation, ID7 and other goodies
out of the box.

Also includes:

* GitHub Actions CI
* Docker (with `docker-compose`)

The application itself is based upon [Spring Boot](https://spring.io/projects/spring-boot) with [Kotlin](https://kotlinlang.org).
[Hibernate](https://hibernate.org/orm/) is used for persistence. Database migrations are handled by [Flyway](https://flywaydb.org).
[FreeMarker](https://freemarker.apache.org) is the template language.
Authentication is provided via [SSO Client](https://github.com/UniversityofWarwick/sso-client) and authorisation is
managed by [Spring Security](https://spring.io/projects/spring-security).

## Getting started

1. Copy `application-example.yml` to `application.yml` and replace the example PostgreSQL database details with your own
1. Copy `external-conf/example-sso-config-example.xml` to `external-conf/example-sso-config.xml` and add your own details
1. Run `./gradlew bootRun` to install dependencies, build assets and compile and run the application
1. Run `./gradlew test` to run the tests
