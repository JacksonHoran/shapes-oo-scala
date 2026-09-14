## Building and running

```
sbt Test/run   # run the Main demonstration
sbt test       # run the unit tests
```

Tests live under [`src/test/scala`](src/test/scala): `TestBoundingBox`,
`TestSize`, `TestHeight`, `TestScale`, and `TestValidation`, reusing the
shared fixtures in `TestFixtures`.

## Logging

Debug output uses [log4s](https://github.com/Log4s/log4s) over the
`slf4j-simple` backend. The log level is configured centrally in
[`src/main/resources/simplelogger.properties`](src/main/resources/simplelogger.properties):

- `org.slf4j.simpleLogger.defaultLogLevel` — set to `debug` for per-node
  tracing, or `info`/`warn`/`error` to quiet it.
- `org.slf4j.simpleLogger.logFile` — currently `System.out`; remove it to log
  to `System.err` (the default) instead.

## Extra credit

- Graphical rendering (`draw` via Doodle): **not attempted**.
- Automated testing of `draw` with `BufferedImage`: **not attempted**.

## AI usage

<!-- Replace this section per the course policy. Either:
     - "AI was used; see <path to transcript>." and commit the transcript, or
     - an affidavit stating AI was not used. -->
