docker rm -f consul
docker run --name consul -d -p 8500:8500 consul

