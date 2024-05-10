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
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean compile test'
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