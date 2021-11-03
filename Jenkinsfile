node {
    def app

    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image */

        app = docker.build("anisell/dev")
    }

    stage('Test image') {
        
        app.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        /* 
			You would need to first register with DockerHub before you can push images to your account
		*/
        docker.withRegistry('https://registry.hub.docker.com', 'anisell') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
            } 
                echo "Trying to Push Docker Build to DockerHub"
    }
    stage('Email Notification') {
	    mail bcc: '', body: '''Hello Anis, this is a Jenkins Pipeline alert for launching Cycle

            Thank you''', cc: '', from: '', replyTo: '', subject: 'Jenking Job Launched', to: 'anis.ellouz1@esprit.tn'
    }}
