def call(String DockerHubUser, String ProjectName, String ImageTag){
  sh "docker rmi ${DockerHubUser}/${ProjectName}:${ImageTag}"
}