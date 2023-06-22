import spock.lang.Execution
import org.spockframework.runtime.model.parallel.ExecutionMode
import spock.lang.Tag

class ConcurrentCasesTest extends ParallelSpecification {
    @Execution(ExecutionMode.CONCURRENT)
    def "ends mark 10"() {
        whoami.set("ends mark 10")
        log.info "waiting... - ${whoami}"
        sleep(10 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Tag("BAT")
    def "ends mark 5"() {
        whoami.set("ends mark 5")
        log.info "waiting... - ${whoami}"
        sleep(5 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }
}
