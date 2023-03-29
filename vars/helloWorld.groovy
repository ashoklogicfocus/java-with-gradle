
library identifier: 'shared-libs@master',
    // 'mylibraryname' is just an identifier, it can be anything you like
    // 'master' refers to a valid git ref (branch)
    retriever: modernSCM([
      $class: 'GitSCMSource',
      credentialsId: '', // remove this if it's public!
      remote: 'https://github.com/ashoklogicfocus/java-with-gradle.git'
])

pipeline {
    agent any
    tools {
        gradle 'Gradle 7.4.2'
    }

    stages {
        stage('checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ashoklogicfocus/java-with-gradle.git']])
            }
        }
        stage('compile') {
          steps {
            step([$class: 'GitHubCommitStatusSetter', statusResultSource: [$class: 'ConditionalStatusResultSource', results: []]])
        }
    }
    stage('test') {
        steps {
            echo "test"
        }
    }
}
}
