pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "hamzaa", 
                    url: "https://github.com/Anisellouz362/Integration",
                    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 
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
