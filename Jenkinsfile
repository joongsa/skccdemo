pipeline {
    agent any
    stages {
        stage('Git Progress') {
          steps {
            git credentialsId: 'jenkinsgit',
            url: 'https://github.com/joongsa/skccdemo'
          }
        }


        stage('Gradle Build') {
          steps {
            sh 'chmod 777 gradlew'
            sh './gradlew build'
            //sh 'gradle clean -b build.gradle'
          }
        }

        stage('Build docker image') {
          steps {
            sh 'docker build -t skccdemo .'
          }
        }

        stage('Docker image push') {
            steps {
                // AWS ECR login
                sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 076554559743.dkr.ecr.ap-northeast-2.amazonaws.com'

                // image tagging
                sh 'docker tag skccdemo:latest 076554559743.dkr.ecr.ap-northeast-2.amazonaws.com/skccdemo:latest'

                // push image
                sh 'docker push 076554559743.dkr.ecr.ap-northeast-2.amazonaws.com/skccdemo:latest'
            }
        }

    }
}