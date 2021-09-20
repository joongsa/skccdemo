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
            sh 'docker build -t skccdemo:latest .'
          }
        }
/*
         stage('Push ecr') {
             sh 'rm  ~/.dockercfg || true'
             sh 'rm ~/.docker/config.json || true'

             docker.withRegistry('https://076554559743.dkr.ecr.ap-northeast-2.amazonaws.com', 'ecr:ap-northeast-2:jenkinsaws') {
                 app.push("${env.BUILD_NUMBER}")
                 app.push("latest")
             }
        }
*/
    }
}