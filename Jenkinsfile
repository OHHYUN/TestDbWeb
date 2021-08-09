pipeline {
    agent any

    stages {
        stage('Clean') {
                steps {
                    sh './gradlew clean'
                }
            }
            stage('Build'){
                steps{
                    sh './gradlew build -Dspring.profiles.active=dev'
                }
            }

        stage('Build docker image') {
            steps {
                sh 'docker build -t board .'
            }
        }

        stage('login'){
            steps{
                sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 783845918471.dkr.ecr.ap-northeast-2.amazonaws.com'
            }
        }

        stage('tag'){
            steps{
                sh 'docker tag board:latest 783845918471.dkr.ecr.ap-northeast-2.amazonaws.com/board:0.91'
            }
        }

        stage('push'){
            steps{
                sh 'docker push 783845918471.dkr.ecr.ap-northeast-2.amazonaws.com/board:0.91'
            }
        }
    }
}