pipeline {
    agent any

    tools {
        gradle 'gradle'
        sonarqube 'Sonar'
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
        stage('Sonarqube') {
            steps {
                sh './gradlew sonarqube -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=testGradle -Dsonar.junit.reportPaths=./build/test-results/test -Dsonar.binaries=./build/classes'
            }
        }
    }
}