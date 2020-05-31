pipeline {
    agent any
    stages {
        stage ('checkout'){
            steps {
            git  'https://github.com/sidtanu/sampleApp.git'
            }
        }

        stage ('test') {
            steps {
                    sh 'echo "hello"'
                   // sh './mvnw test'
		    sh 'chmod -R 775 ./53-LetterExpress-Proxy-Service/mvnw'
            }
         }       

        stage ('package') {
            steps {
                    sh './53-LetterExpress-Proxy-Service/mvnw clean package'
            }
         }
        stage ('sonar') {
            steps {
		    archiveArtifacts artifacts: '**/*.jar', excludes: 'maven-wrapper.jar', onlyIfSuccessful: true
            }
         }     
    }
}
