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
                        echo "ХУЙ: ${params.results}"
                        allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                        ])
                    }
                }
            }
        }
    }
}
