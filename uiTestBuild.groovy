pipeline {
    agent any
    parameters {
        string(name: 'results', defaultValue: '[[path: \'target/surefire-reports\']]')
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
        stage('reports') {
            steps {
                script {
                    script {
                        echo "Путь к отчету Allure: ${params.results}"
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: ${params.results}
                    ])
                    }
                }
            }
        }
    }
}
