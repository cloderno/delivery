hello:
	echo "hello"

build:
	@go build -o bin/delivery

run: build
	@./bin/delivery

test: 
	@go test -v ./...