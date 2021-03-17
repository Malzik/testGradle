pipeline {
    agent any

    tools {
        gradle 'gradle'
    }

    stages {
		stage ('Build') {
        	steps {
        		sh './gradlew clean build'
        	}
            post {
                success {
                    archiveArtifacts artifacts: '**/build/**/*.jar', fingerprint: true
                }
            }
         }
		stage ('Test') {
        	steps {
        		sh './gradlew test'
        	}
            post {
                success {
                    junit 'build/test-results/**/*.xml'
                }
            }
         }
    }
}