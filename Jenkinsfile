pipeline {
   options
    {
      buildDiscarder(logRotator(numToKeepStr: '3'))
    }
    agent any

    environment {
      AWS_ACCOUNT_ID="422288715120"
      AWS_DEFAULT_REGION="us-east-1" 
      IMAGE_REPO_NAME="ss-utopia-card"
      IMAGE_TAG="latest"
      REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
    }

    stages {       

      stage('checkout') {
        steps {
          git branch: 'develop', credentialsId: 'git_login', url: 'https://github.com/byte-crunchers/ss-utopia-card.git'
        }
      }

      stage("Clean install") {  
        steps {
          sh 'mvn clean install'
        }
      }
        
      stage("SonarQube analysis") {
        steps {
          withSonarQubeEnv('SonarQube') {
            sh 'mvn sonar:sonar'
          }
        }
      }
    
      stage("Quality Gate") {
        steps {
          echo message: "can not do on local machine "
          /* timeout(time: 5, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
          }*/
        }
      }

      stage('Build') {
        steps {
          sh 'docker build . -t ss-utopia-card:latest'
        }
      }

      stage('Deploy') {
        steps {
          script{
            docker.withRegistry("https://${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com", 'ecr:us-east-1:ss-AWS') 
            {
              docker.image('ss-utopia-card').push('latest')
            }
          }
        }
      }
    }
}


