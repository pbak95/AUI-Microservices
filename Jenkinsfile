pipeline {
  agent {
    dockerfile {
      filename 'DateAndTime/src/test/docker/Dockerfile'
    }
  }
  stages {
    stage('Test') {
      steps {
        sh '''ls -al
        cd /usr/src/app/DateAndTime
        ls -al
        mvn clean verify
        '''
      }
    }
    stage('deploy') {
      steps {
        echo 'Ready for deploy!'
      }
    }
  }
}