ssh  -i spring-boot-docker-key-pair.pem ec2-user@ec2-13-127-8-76.ap-south-1.compute.amazonaws.com 
pwd
sudo -i
docker run -d -p 8000:8091 ksaubhri/spring-boot-docker