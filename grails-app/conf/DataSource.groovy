dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.postgresql.Driver"
    username = "postgres"
    password = "postgres"
    dialect = "org.hibernate.dialect.PostgreSQLDialect"
    dbCreate = "" // one of 'create', 'create-drop', 'update', 'validate', ''
    url = "jdbc:postgresql://localhost/es-test"

}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}