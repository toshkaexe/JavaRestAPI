mvn -f pom.xml clean package
docker build -f Dockerfile -t backend .
docker run --publish 8086:8086 -it backend
