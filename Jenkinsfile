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
            }
         }       

        stage ('package') {
            steps {
                    sh './mvnw clean package'
            }
         }
        stage ('sonar') {
            steps {
					sh 'echo "hello11"'
            }
         }     
    }
}
