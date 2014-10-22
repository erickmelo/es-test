package br.ufscar.es.test

import grails.transaction.Transactional
import grails.util.GrailsNameUtils
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.elasticsearch.action.get.GetRequest

@Transactional
class CatmatService {

    def grailsApplication
    def elasticSearchHelper

    private String getIndexName(GrailsDomainClass domainClass) {
        String name = grailsApplication.config.elasticSearch.index.name ?: domainClass.packageName
        if (name == null || name.length() == 0) {
            name = domainClass.getPropertyName()
        }
        return name.toLowerCase()
    }

    private String getTypeName(GrailsDomainClass domainClass) {
        GrailsNameUtils.getPropertyName(domainClass.clazz)
    }

    def findFailures() {
        def domainClass = new DefaultGrailsDomainClass(Catmat)
        def failures=[]
        def allObjects = Catmat.list()
        allObjects.each {
            elasticSearchHelper.withElasticSearch { client ->
                GetRequest getRequest = new GetRequest(getIndexName(domainClass), getTypeName(domainClass), it.id.toString());
                def result = client.get(getRequest).actionGet()
                if (!result.isExists()) {
                    failures << it
                }
            }
        }
        return failures
    }
}
