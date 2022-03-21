
@Library('jenkins shared library')
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
            when {
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps{
              script{
                  echo "branch : ${BRANCH_NAME}"
                  gv.buildJar()
                  
              }
            }
            
        }
        stage("build docker-image"){
            steps{
              script{
                  buildImage()
                  
                  
              }
            }
            
        }
         stage("push docker-image"){
            steps{
              script{
                  pushImage()
                  
              }
            }
            
        }
       
    }
}
