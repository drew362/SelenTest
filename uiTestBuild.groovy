pipeline {
    agent any
    tools {
        maven 'Maven jenkins'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/drew362/SelenTest.git'
            }
        }
        stage('Run UI Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('reports') {
            steps {
                script {
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/surefire-reports']]
                        ])
                    }
                }
            }
        }
    }
}
