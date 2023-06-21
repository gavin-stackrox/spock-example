import spock.lang.Execution
import org.spockframework.runtime.model.parallel.ExecutionMode

class ConcurrentCasesTest extends ParallelSpecification {
    @Execution(ExecutionMode.CONCURRENT)
    def "ends mark 10"() {
        // while (syncSetupTest < 100) {
        //     log.info("10>> ${syncSetupTest}")
        //     syncSetupTest++
        // }
        whoami.set("ends mark 10")
        log.info "waiting... - ${whoami}"
        sleep(10 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }

    @Execution(ExecutionMode.CONCURRENT)
    def "ends mark 5"() {
        // while (syncSetupTest < 100) {
        //     log.info("5 >> ${syncSetupTest}")
        //     syncSetupTest++
        // }
        whoami.set("ends mark 5")
        log.info "waiting... - ${whoami}"
        sleep(5 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }
}
