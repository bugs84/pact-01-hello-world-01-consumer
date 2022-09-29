## Sources:

https://github.com/DiUS/pact-jvm


## sample:
https://github.com/DiUS/pact-jvm/tree/master/consumer/junit5



## VYMENA PACT FILU:
jak pisou zde:  https://github.com/Mikuu/Pact-JVM-Example#11-example-provider

použít:
https://github.com/pact-foundation/pact_broker





## Jak tohle funguje
V testech je 'FirstPactTest'
Ten má namockovaného providera a zkouší že se chová jak potřebuje


`gradlew test`
do 'build/pacts' se nageneruje pact file 'test_consumer-ArticlesProvider.json'
generuje se spuštěním toho testu

Pak se tenhle file dopravi do providera (kopirovani/artifactor/pact broker)


ArticlesConsumer a ArticlesConsumerTest - is HelloWorld, which is a little bit closer to real world example


## wiremock pact generator
pact fily jdou nagenrovat i tímhle:
https://bitbucket.org/atlassian/wiremock-pact-generator/src/master/
viz. tenhle článek:
https://zararsiddiqi.com/2019-09-19-contract-testing-junit5-pact-spring-wiremock/
 