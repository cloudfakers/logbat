# Logback extensions

To use these extensions you just need to add the `logbat-0.1-SNAPSHOT.jar` to in the classpath. 

## Batman

This is an Encoder extending the default ```LayoutWrappingEncoder``` that punch the log before dumping a stack trace.

### Configuration

In `logback.xml`

```xml
<encoder class="com.github.cloudfackers.logbat.BatmanEncoder">
	<layout class="ch.qos.logback.classic.PatternLayout">
	    <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
	</layout>
</encoder>
```



ANSI art thanks to [ansify](http://github.com/enricruiz/ansify).

### Example

![bang](http://i.imgur.com/zxAWYib.png)

## Oracle Ase

This is just a converter that properly prefixes and suffixes the log messages for the
`oracle-ase` plugin to a more proper format.

### Configuration

In `logback.xml`, as a top-level configuration element:

```xml
<conversionRule conversionWord="msg"
                converterClass="com.github.cloudfackers.oraclease.OracleAseConverter" />
```

### Example

The following code:

```java
private static final Logger LOG = LoggerFactory.getLogger(VirtualMachineService.class);
private static final Logger PLUGIN_LOG = LoggerFactory.getLogger(OracleAsePlugin.class);

public static void main(String[] args) {
    LOG.info("Preparing VM deploy...");
    PLUGIN_LOG.info("Deploying VM");
}
```

Produces the output. Note that the converter only prefixes the oracle-ase plugin logs.

```bash
15:22:06.512 [main] INFO  c.a.a.s.c.VirtualMachineService - Preparing VM deploy...
15:22:06.517 [main] INFO  c.a.p.oraclease.OracleAseConnection - oracle-ase, Deploying VM? O que ase
```
