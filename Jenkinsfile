pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "MedLadhibi", 
                    url: "https://github.com/Anisellouz362/Integration",
                    credentialsId: "9c728a3e-295b-42f6-9fbb-e43fa67f96ae"; 
            }
        }

        stage("Build") {
            steps {
                echo "Building the project"; 
                bat "mvn clean -DskipTests"
                bat "mvn install -DskipTests"
                bat "mvn package -DskipTests"
            }
        }
        
        stage("Sonar") {
            steps {
                echo "Testing with sonnar"; 
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                echo "Deploying on Nexus"; 
                bat "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}