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

}