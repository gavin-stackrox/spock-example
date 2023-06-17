import BaseService

class AConcurrentSuiteTest extends ParallelSpecification {
    def setupSpec() {
        BaseService.doThisInstead("Behave the A way")
    }

    def "ends mark 9"() {
        whoami.set("ends mark 9")
        log.info "waiting... - ${whoami}"
        sleep(9 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }

    def "ends mark 16"() {
        whoami.set("ends mark 16")
        log.info "waiting... - ${whoami}"
        sleep(7 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }
}
