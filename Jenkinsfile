pipeline{
    agent any
    stages {
        stage('build') {
            steps('hello') {
                sh '''
                chmod +x gradlew && ./gradlew build
                '''
            }
        }
        stage('deploy') {
            steps('bye') {
                sh 'echo "bye"'
            }
        }
    }
}