pipeline{
    agent any
    stages {
        stage('build') {
            steps('hello') {
                sh 'cd build-folder && ./gradlew build'
            }
        }
        stage('deploy') {
            steps('bye') {
                sh 'echo "bye"'
            }
        }
    }
}