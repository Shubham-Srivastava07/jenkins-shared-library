def call(String credId, String imageName, String imageTag){
  withCredentials([usernamePassword(
    credentialsId:credId,
    usernameVariable:"dockerHubUser",
    passwordVaribale:"dockerHubpass")]){
    sh 'ech $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
    sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
    sh "docker push ${env.dockerHubUser}/${imageNmae}:${imagetag}"
  }
}  
