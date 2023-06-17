import spock.lang.Execution
import org.spockframework.runtime.model.parallel.ExecutionMode

class ConcurrentCasesTest extends ParallelSpecification {
    @Execution(ExecutionMode.CONCURRENT)
    def "ends mark 10"() {
        log.info "waiting..."
        sleep(10 * 1000)
        expect:
        "a" == "a"
    }

    @Execution(ExecutionMode.CONCURRENT)
    def "ends mark 5"() {
        log.info "waiting..."
        sleep(5 * 1000)
        expect:
        "a" == "a"
    }
}
