Getting started with Docker
---------------------------

### Pre-requisites:

- Docker > v18
- docker-compose >= 1.25.0

Now is a good time to `$ sudo pip3 install --upgrade docker-compose`

### Running all the services

You need port 443 and 80 free'd up on the host.

```
$ sudo COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up
```

Now visit `https://localhost`.

If you have a real domain, feel free to change the `Caddyfile` in this directory:

```
example.domain.com
proxy / app:8080
```

**That's it**. Caddy will request, obtain, and install the cert, redirect HTTP requests to HTTPS, implement a modern, secure TLS configuration, and renew the cert as required.

#### I work within ITS

You probably have your own reverse proxy, pointing at localhost:8080 amirite? No problem.

```
$ mv docker-compose-its.yml docker-compose.override.yml
$ sudo COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up
```

Now port `8080` will be forwarded. You'll probably want to adjust `example-sso-config-example-docker.yml` to match your
ITS-issued SSO service details. If you decide to do this, re-build the app container:

```
$ sudo COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose build
$ sudo COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose up --force-recreate
```


### Caveats

The certificates/keys in this directory are not trusted by any real
SSO instance.

External contributors: you'll need to use [sso-stub](https://github.com/UniversityofWarwick/sso-stub) to get SSO
to work, which is not currently finished.