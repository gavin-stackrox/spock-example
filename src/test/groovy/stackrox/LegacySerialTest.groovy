class LegacySerialTest extends SerialSpecification {
    def "lets get started"() {
        sleep(100)
        expect:
        "a" == "a"
    }

    def "and test more"() {
        sleep(100)
        expect:
        "a" == "a"
    }
}
