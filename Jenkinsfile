


def gv
pipeline{

    agent any
  tools {
    maven 'maven'
  }
	environment{
	BRANCH_NAME = "master"
}
    stages{
        
        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            
            }
        }
        stage("increment version"){
            steps{
                script{
                    echo "incrementing project version"
                    sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parseVersion.nextIncrementalVersion} versions:commit'
                }
            }
        }
      stage("show version"){
            steps{
                script {
			echo "${BRANCH_NAME}"
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
