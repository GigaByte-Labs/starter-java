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
        stage('Grading - maven Clean and verify') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean verify"
            }
        }
        stage('Grading - Surefire generate reports') {
            steps {
                // Generate report
                sh "mvn surefire-report:report-only"
            }
        }
        stage('Grading - Surefire generate html assets') {
            steps {
                // Generate html files css and imgaes
                sh "mvn site -DgenerateReports=false"
                echo "Finidhing JOB NAME = ${FOLDER_DEST}"
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
