Batman logback exceptions 
=========================

This is an Encoder extending the default ```LayoutWrappingEncoder``` that punch the log before dumping a stack trace.


Configuration
-------------

in ```logback.xml```

```xml
<encoder class="com.github.cloudfackers.logbat.BatmanEncoder">
	<layout class="ch.qos.logback.classic.PatternLayout">
	    <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
	</layout>
</encoder>
```

check logback version and make sure ```logbat-0.1-SNAPSHOT.jar``` is in the classpath.


ANSI art thanks to [ansify](http://github.com/enricruiz/ansify).

Example
-------

![bang](http://i.imgur.com/zxAWYib.png)


