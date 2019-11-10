pipeline{
    agent any
    stages {
        stage('build') {
            steps('hello') {
                sh './gradlew build'
            }
        }
        stage('deploy') {
            steps('bye') {
                sh 'echo "bye"'
            }
        }
    }
}