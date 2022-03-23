def buildJar(){
    echo "building the jar"
    sh 'mvn clean package' 
}
def buildImage(){
    echo "${IMAGE_NAME}"
                    sh "docker build -t oubaydos/temp:${IMAGE_NAME} ."
}
def pushImage(){
    echo "pushing the docker image"
            withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                sh "docker push oubaydos/temp:$IMAGE_NAME"
                }
}
return this
