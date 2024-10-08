#!groovy

pipeline {
  agent none
  stages {

    stage('Docker Build') {
      agent any
      steps {
        sh 'docker compose build'
      }
    }
    stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker tag account-app satish21061985/account-app'
          sh 'docker push satish21061985/account-app'
        }
      }
    }
    stage('Docker Deploy') {
          agent any
          steps {
              sh 'docker compose up'
            }
          }
        }
  }
}