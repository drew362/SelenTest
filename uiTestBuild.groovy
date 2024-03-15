pipeline {
    agent any

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
                sh 'clean test'
            }
        }
    }
}
