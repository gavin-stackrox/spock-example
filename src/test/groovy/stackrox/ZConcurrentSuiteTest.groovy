class ZConcurrentSuiteTest extends ParallelSpecification {
    def "ends mark 8"() {
        log.info "waiting..."
        sleep(8 * 1000)
        expect:
        "a" == "a"
    }

    def "ends mark 11"() {
        log.info "waiting..."
        sleep(3 * 1000)
        expect:
        "a" == "a"
    }
}
