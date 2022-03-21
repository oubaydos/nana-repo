
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
                    BRANCH_NAME == 'master' || BRANCH_NAME == 'shared-library'
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
                  buildImage "temp" "jenkins_file"
                  
                  
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
