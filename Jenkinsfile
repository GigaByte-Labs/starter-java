pipeline {
    agent any

    options {
        timestamps()
    }

    environment{
        FOLDER_DEST = "grades-${JOB_NAME}-${BUILD_NUMBER}"
    }

    stages {
        /* stage('GitHub') {
            steps{
                // Get some code from a GitHub repository
                git branch: 'main', url: ''
            }
        } */
        stage('Grading') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean verify"
                // Generate report
                sh "mvn surefire-report:report"
                // Generate html files css and imgaes
                sh "mvn site -DgenerateReports=false"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                    archiveArtifacts artifacts: 'target/site/**'
                }
            }
        }
    }
}
