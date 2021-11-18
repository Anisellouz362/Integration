pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "hamzaa", 
                    url: "https://github.com/Anisellouz362/Integration",
                    credentialsId: "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";
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
              
                bat "mvn deploy -DskipTests"
            }
        }
    }
   
    post {
    always {
       mail to: 'abdelwahed.hamza9@gmail.com',
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
    }
  }
        post {
        always {
            cleanWs()
        }
    }
}
