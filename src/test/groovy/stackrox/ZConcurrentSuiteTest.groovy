class ZConcurrentSuiteTest extends ParallelSpecification {
    def "ends mark 8"() {
        whoami.set("ends mark 8")
        log.info "waiting... - ${whoami}"
        sleep(8 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }

    def "ends mark 11"() {
        whoami.set("ends mark 11")
        log.info "waiting... - ${whoami}"
        sleep(3 * 1000)
        log.info "done - ${whoami}"
        expect:
        "a" == "a"
    }
}
