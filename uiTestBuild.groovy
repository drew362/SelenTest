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
        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('reports Allure') {
            steps {
                script {
                    script {
                        allure([
                                includeProperties: false,
                                jdk              : '',
                                reportBuildPolicy: 'ALWAYS',
                                results          : [[path: 'target/surefire-reports']]
                        ])
                    }
                }
            }
        }

    }
    post {
        always {
            archiveArtifacts 'allure-report'
        }
    }
}
