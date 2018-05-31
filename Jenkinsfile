pipeline {
  agent {
    dockerfile {
      filename 'DateAndTime/src/test/docker/Dockerfile'
    }
  }
  stages {
    stage('Test') {
      steps {
        sh 'mvn clean verify'
      }
    }
    stage('deploy') {
      steps {
        echo 'Ready for deploy!'
      }
    }
  }
}