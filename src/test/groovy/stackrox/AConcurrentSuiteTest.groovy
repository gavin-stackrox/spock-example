import spock.lang.Execution
import org.spockframework.runtime.model.parallel.ExecutionMode

class AConcurrentSuiteTest extends ParallelSpecification {
    def "ends mark 9"() {
        log.info "waiting..."
        sleep(9 * 1000)
        expect:
        "a" == "a"
    }

    def "ends mark 16"() {
        log.info "waiting..."
        sleep(7 * 1000)
        expect:
        "a" == "a"
    }
}
