package br.ufscar.es.test



import spock.lang.*

/**
 *
 */
class CatmatSpec extends Specification {
    def catmatService

    def setup() {
        Catmat.unindex()
    }

    def cleanup() {
    }

    void "test index"() {
        when: "Catmat is indexed from database"
            Catmat.index()
        then: "The index contain all elements of database"
            catmatService.findFailures()?.size()==0

    }
}
