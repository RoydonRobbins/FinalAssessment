pipeline {
	agent any
  tools {
    maven 'M3'
  }
  stages {
    stage('checkout') {
      steps {
      	git branch : 'main', url : 'https://github.com/RoydonRobbins/FinalAssessment.git'
      
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean compile'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
  }
}