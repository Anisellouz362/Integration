pipeline{

	agent any

	environment {
		DOCKERHUB_CREDENTIALS=credentials('anisell')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -t anisell/dev:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push anisell/dev:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}