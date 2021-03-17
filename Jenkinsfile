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
        stage('Sonarqube') {
            withSonarQubeEnv() {
                sh 'gradle -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=testGradle -Dsonar.junit.reportPaths=./build/test-results/test -Dsonar.binaries=./build/classes'
            }
        }
    }
}