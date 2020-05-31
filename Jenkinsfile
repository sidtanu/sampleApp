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
                    sh '''
		    	echo "hello"
			chmod -R 775 ./53-LetterExpress-Proxy-Service/mvnw
                   	./53-LetterExpress-Proxy-Service/mvnw test
		    '''
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
