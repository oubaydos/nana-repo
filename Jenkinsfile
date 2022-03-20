pipeline{

    agent any
  tools {
    maven 'maven'
  }
    stages{
      stage("show version"){
            steps{
                sh 'npm --version'
            }
        }
        stage("build jar"){
            steps{
              script{
                  echo "building the jar"
                  sh 'mvn package' 
              }
            }
            
        }
        stage("build docker-image"){
            steps{
              script{
                  echo "building the docker image"
                  sh 'docker build -t oubaydos/temp:jenkins_file .' 
                  
              }
            }
            
        }
         stage("push docker-image"){
            steps{
              script{
                  echo "pushing the docker image"
                  withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh 'docker push oubaydos/temp:jenkins_file'
                  }
                  
              }
            }
            
        }
       
    }
}
