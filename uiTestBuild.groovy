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

//        stage('Build') {
//            steps {
//                sh 'mvn clean test'
//            }
//        }

        stage('Run UI Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Генерация отчета Allure') {
            steps {
                script {
                    sh 'mvn allure:report'
                }
                post {
                    always {
                        allure([includeProperties: false, jdk: '', results: [[path: 'target/surefire-reports']], reportBuildPolicy: 'ALWAYS', report: true])
                    }
                }
            }
        }
    }
}
