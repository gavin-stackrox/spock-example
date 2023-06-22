class OtherSerialTest extends SerialSpecification {
    def "other serial test"() {
        sleep(100)
        expect:
        "a" == "a"
    }
}
