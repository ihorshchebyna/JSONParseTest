pipeline{
    agent any
    stages {
        stage('build') {
            steps('hello') {
                sh 'echo ./gradlew build'
            }
        }
        stage('deploy') {
            steps('bye') {
                sh 'echo "bye"'
            }
        }
    }
}