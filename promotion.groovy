pipeline {
    agent any
    stages {
        stage('Pre-Build') {
            steps {
                echo 'Any Pre-requisite steps before the CodeBuild'
            }
        }
        stage('Build on AWS CodeBuild') {
            steps {
                    awsCodeBuild buildSpecFile: 'buildspec.yml',
                        credentialsId: '92codebuildroot',
                        credentialsType: 'jenkins',
                        projectName: 'satest',
                        region: 'us-east-1',      
                        sourceControlType: 'jenkins',
                        sourceLocationOverride: 'sftp-bucket-poswal091993/art.zip',
                        sourceTypeOverride: 'S3'
            }
        }
    }
}
        
