run-dev: build
	$(info >> starting play framework on http://localhost:9000)
	sbt ~run

run-prod: build
	sbt dist
	(cd target/universal && unzip play-vue-webpack-spa-1.1.zip -d production && cd production/play-vue-webpack-spa-1.1/bin && ./play-vue-webpack-spa)

build:
	(cd front && npm install)
	sbt update compile dist

clean:
	sbt clean
	rm -rf front/node_modules
	rm -rf project/project
	rm -rf project/target
	rm -rf public/bundle
	rm -rf target

.PHONY: run-dev run-prod build clean
