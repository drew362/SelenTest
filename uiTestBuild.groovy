pipeline {
    agent any
    parameters {
        string(name: 'results', defaultValue: ':\'target/surefire-reports\'')
    }
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
                        echo "Путь к отчету Allure: ${params.results}"
                        allure([
                                includeProperties: true,
                                jdk              : '',
                                properties       : [],
                                reportBuildPolicy: 'ALWAYS',
                                results          : [[path: '${params.results}']]
                        ])
                    }
                }
            }
        }
    }
}
