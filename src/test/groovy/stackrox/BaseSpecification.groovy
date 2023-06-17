import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Tag
import BaseService

@Tag("StackRox")
class BaseSpecification extends Specification {
    @Shared
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName())

    public static ThreadLocal<String> whoami = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "no one";
        }
        @Override
        public String toString() {
            return this.get();
        }
    };

    def setupSpec() {
        log.info("Starting specification - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }

    def setup() {
        log.info("Starting feature - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }

    def cleanup() {
        log.info("ending feature - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }

    def cleanupSpec() {
        log.info("ending specification - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }
}
