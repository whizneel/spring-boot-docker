node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */
        echo 'kalpesh'
        checkout scm
    }
    stage('Test Image'){
        sh '/usr/local/apache-maven-3.5.4/bin/mvn test'
    }
    stage('Building Jarfile'){
        sh '/usr/local/apache-maven-3.5.4/bin/mvn package'
    }
    stage('Create docker image'){
        sh 'sudo /usr/local/bin/docker build -t spring-boot-docker .'
    }
    stage('Pushing docker image'){
        sh 'sudo /usr/local/bin/docker login --username=ksaubhri --password=kalpesh482'
        echo 'login successfully'
        sh "echo ${env.user_name}"
        sh 'sudo /usr/local/bin/docker tag spring-boot-docker ksaubhri/spring-boot-docker'
        echo 'push successfull'
    }

}