node {
    def app

    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image */

        app = docker.build("test/integration")
    }

    stage('Test image') {
        
        app.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        withDockerRegistry([ credentialsId: "docker-hub-credentials", url: "" ]) {
        bat "docker push test/integration:build"
        }
                echo "Trying to Push Docker Build to DockerHub"
    }
}