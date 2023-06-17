import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Tag

@Tag("StackRox")
class BaseSpecification extends Specification {
    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName())

    def setupSpec() {
        log.info("Starting specification")
    }

    def setup() {
        log.info("Starting feature")
    }

    def cleanup() {
        log.info("ending feature")
    }

    def cleanupSpec() {
        log.info("ending specification")
    }
}
