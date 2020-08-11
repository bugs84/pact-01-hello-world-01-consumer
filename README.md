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

do 'build/pacts' se nageneruje pact file 'test_consumer-ArticlesProvider.json'
generuje se spuštěním toho testu

Pak se tenhle file dopravi do providera (kopirovani/artifactor/pact broker)

 