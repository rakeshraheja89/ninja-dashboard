pipeline {
 agent any
stages {
 stage('CodeCheckout') {
 steps {
 script {
    checkout scm
     def mvnHome = tool 'mavan-3'
     def javaHome = tool 'java8'
     }
    }
   }
   
 stage('build customer app code') { 
 steps {
  script {
        def mvnHome = tool 'mavan-3'
        def javaHome = tool 'java8'
        mvn clean install
    }
  }
 }
}
}
