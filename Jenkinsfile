
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
        echo "${env.BRANCH_NAME}"    
	when {
                expression{
                   env.BRANCH_NAME == 'master'
                }
            }
            steps{
              script{
                  echo "branch : ${env.BRANCH_NAME}"
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
