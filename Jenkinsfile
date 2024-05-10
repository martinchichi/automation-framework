pipeline {
    agent any

    tools {
        jdk 'jdk8'
        maven 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/martinchichi/automation-framework.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                cucumber buildStatus: 'NULL',
                         fileIncludePattern: '**/cucumber*.json',
                         jsonReportDirectory: 'target/cucumber-reports'
            }
        }
    }

    post {
        always {
            archiveArtifacts 'target/**/*'
        }
    }
}