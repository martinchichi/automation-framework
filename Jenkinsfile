pipeline {
    agent any

    tools {
        jdk 'Java_JDK'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/martinchichi/automation-framework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                cucumber buildStatus: 'NULL',
                         fileIncludePattern: '**/cucumber*.json',
                         jsonReportDirectory: 'target'

            }
        }
    }

    post {
        always {
            archiveArtifacts 'target/**/*'
        }
    }
}
