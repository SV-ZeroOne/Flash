/**
 * Created by byron.dinkelmann on 2017/01/19.
 */
/*import ch.qos.logback.core.ConsoleAppender
appender("STDOUT", ConsoleAppender) {
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
root(INFO, ["STDOUT"])*/

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}
root(DEBUG, ["STDOUT", "FILE"])