# CDC - Consumer Driven Contract tests - Usage example of pact.io for test
This is example pact.io tests for "Consumer" application.  
For example of CDC test using Pact Broker see [Hello world pact broker](https://github.com/bugs84/pact-01-hello-world-pact-broker)

## Associated projects:
- https://github.com/bugs84/pact-01-hello-world-01-consumer
- https://github.com/bugs84/pact-01-hello-world-02-producer
- https://github.com/bugs84/pact-01-hello-world-pact-broker

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
 