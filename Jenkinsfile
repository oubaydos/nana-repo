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
       
    }
}
