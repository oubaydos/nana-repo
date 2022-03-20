def buildJar(){
    echo "building the jar"
    sh 'mvn package' 
}
def buildImage(){
    echo "building the docker image"
    sh 'docker build -t oubaydos/temp:jenkins_file .' 
}
def pushImage(){
    echo "pushing the docker image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push oubaydos/temp:jenkins_file'
    }
}
return this
