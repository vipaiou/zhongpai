MVN = ../maven/bin/mvn

.PHONY: all clean

all:
	$(MVN) package -D maven.test.skip=true

clean:
	$(MVN) clean 
