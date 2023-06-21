import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Tag
import BaseService
import ch.qos.logback.classic.LoggerContext;

@Tag("StackRox")
class BaseSpecification extends Specification {
    @Shared
    Logger log = LoggerFactory.getLogger("test." + this.class.getName())
    // Logger log = LoggerFactory.getLogger("test." + this.getClass().getSimpleName())

    static final Logger LOG = LoggerFactory.getLogger("test." + BaseSpecification.getSimpleName())

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

    // # ref: https://medium.com/@BillyKorando/how-to-test-logging-in-java-part-two-parallel-boogaloo-28d563c15a3d
	private static boolean isLogbackReady() {
		try {
			LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		} catch (ClassCastException castException) {
			return false;
		}
		return true;
	}

    // @Shared
    // public static ThreadLocal<Logger> log = new ThreadLocal<Logger>() {
    //     @Override
    //     protected Logger initialValue() {
    //         println this.getClass().getSimpleName().toString()
    //         return LoggerFactory.getLogger()
    //     }

    //     public void info(String format) {
    //         this.get().info(format)
    //     }
    // }

    @Shared
    Integer syncSetupTest = 0

    private static boolean globalSetupDone = false

    private static synchronizedGlobalSetup() {
        synchronized(BaseSpecification) {
            globalSetup()
        }
    }

    private static globalSetup() {
        if (globalSetupDone) {
            LOG.info("globalSetup done")
            return
        }
        LOG.info("I'm doing global setup. The rest of you can ...")
        sleep(5000)
        globalSetupDone = true
    }

    def setupSpec() {
        while (!isLogbackReady()) {
            println "Logging is not yet ready"
            sleep(100)
        }
        synchronizedGlobalSetup()
        log.info("Starting specification - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }

    def setup() {
        log.info("Starting feature - ${whoami} - ${BaseService.whatAreYouDoing()}")
        synchronized("aSharedSpecVariable") {
            if (syncSetupTest == 0) {
                log.info("Only 1 feature setup() per spec should get here")
                syncSetupTest = 1
            }
        }
    }

    def cleanup() {
        log.info("ending feature - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }

    def cleanupSpec() {
        log.info("ending specification - ${whoami} - ${BaseService.whatAreYouDoing()}")
    }
}
