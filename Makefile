MAIN_CLASS = cs1302.calc.CalcApp

run: compile
	export MAVEN_OPTS="-Dprism.order=sw"; \
	mvn exec:java -Dexec.mainClass="$(MAIN_CLASS)"

compile:
	mvn compile

clean:
	mvn clean

doc:
	mvn javadoc:javadoc
