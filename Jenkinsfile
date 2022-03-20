
def gv
pipeline{

    agent any
  tools {
    maven 'maven'
  }
    stages{
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            
            }
        }
      stage("show version"){
            steps{
                script {
                    sh 'npm --version'
                }
            }
        }
        stage("build jar"){
            steps{
              script{
                  gv.buildJar()
                  
              }
            }
            
        }
        stage("build docker-image"){
            steps{
              script{
                  gv.buildImage()
                  
                  
              }
            }
            
        }
         stage("push docker-image"){
            steps{
              script{
                  gv.pushImage()
                  
              }
            }
            
        }
       
    }
}
