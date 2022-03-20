
def gv
pipeline{

    agent any
  tools {
    maven 'maven'
  }
    stages{
        stage("init"){
            gv = load "script.groovy"
        }
      stage("show version"){
            steps{
                gv.buildJar()
            }
        }
        stage("build jar"){
            steps{
              script{
                  gv.buildImage()
              }
            }
            
        }
        stage("build docker-image"){
            steps{
              script{
                  gv.pushImage()
                  
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
