run-dev: clean update
    $(info >> starting play framework on http://localhost:9000)
    sbt ~run

run-prod: clean update
	sbt dist
	(cd target/universal && unzip play-vue-webpack-spa-1.1.zip -d production && cd production/play-vue-webpack-spa-1.1/bin && ./play-vue-webpack-spa)

update:
	(cd front && npm update)
	sbt clean update compile

clean:
	rm -rf front/node_modules
	rm -rf project/project
	rm -rf project/target
	rm -rf public/bundle
	rm -rf target

.PHONY: run-dev run-prod update clean
