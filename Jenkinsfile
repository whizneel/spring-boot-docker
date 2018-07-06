node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */
        echo 'kalpesh'
        checkout scm
    }
    stage('Test Image'){
        sh 'mvn test'
    }
    stage('Building Jarfile'){
        sh 'mvn package'
    }
    stage('Create docker image'){
        sh 'docker build -t spring-boot-docker .'
    }
    stage('Pushing docker image'){
        sh "docker login --username=${env.dockerHub_user_name} --password=${env.dockerHub_password}"
        echo 'login successfully'
        sh 'docker tag spring-boot-docker ksaubhri/spring-boot-docker'
        sh 'docker push ksaubhri/spring-boot-docker'
        echo 'push successfull'
    }
    stage('aws login'){
        sh 'chmod 400 spring-boot-docker-key-pair.pem'
        sh 'ssh -T -o StrictHostKeyChecking=no -i spring-boot-docker-key-pair.pem ec2-user@ec2-13-127-8-76.ap-south-1.compute.amazonaws.com <<EOM'
        sh 'pwd'
        sh 'docker run -d -p 8000:8091 ksaubhri/spring-boot-docker'
    }

}