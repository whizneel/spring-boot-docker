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
        sh 'sudo /usr/local/bin/docker login --username=ksaubhri --password=kalpesh482'
        echo 'login successfully'
        sh "echo ${env.user_name}"
        sh 'sudo /usr/local/bin/docker tag spring-boot-docker ksaubhri/spring-boot-docker'
        echo 'push successfull'
    }

}