node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */
        input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                    }
        }
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

}