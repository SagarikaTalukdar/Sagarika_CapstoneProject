pipeline {

agent any

tools {
    jdk 'JDK-17'
    maven 'Maven-3.9'
}

environment {
    MAVEN_OPTS = '-Xmx1024m'
}

stages {

    stage('Checkout Code') {
        steps {
            git branch: 'main',
                url: https://github.com/SagarikaTalukdar/Sagarika_CapstoneProject.git
        }
    }

    stage('Clean Workspace') {
        steps {
            bat 'mvn clean'
        }
    }

    stage('Compile Project') {
        steps {
            bat 'mvn compile'
        }
    }

    stage('Execute TestNG Tests') {
        steps {
            bat 'mvn test'
        }
    }

    stage('Generate Reports') {
        steps {
            junit 'target/surefire-reports/*.xml'
        }
    }

    stage('Archive Artifacts') {
        steps {
            archiveArtifacts artifacts: 'target/**/*.*',
                             fingerprint: true
        }
    }
}

post {

    always {
        echo 'Pipeline Execution Completed'
    }

    success {
        echo 'Automation Execution Successful'
    }

    failure {
        echo 'Automation Execution Failed'
    }
}

}
