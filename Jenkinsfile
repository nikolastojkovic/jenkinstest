def gv

pipeline {
    agent any
    triggers {
        // cron('H 10-12/1 * * 1-5')
        pollSCM('*/2 * * * 1-5') // poll every 2min each workday
        // pollSCM('06 10 * * 1-5') // UTC time
    }
    parameters {
        // choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        // if true - always pull the latest docker image
        booleanParam(name: 'rollAlways', defaultValue: true, description: 'Pull the latest Docker image')
        // booleanParam(name: 'destroy', defaultValue: false, description: 'Helmfile -e dbh-v1-dev destroy')
        // booleanParam(name: 'apply', defaultValue: false, description: 'Helmfile -e dbh-v1-dev apply')
        choice(name: 'DEPLOYMENT', choices: ['N/A', 'destroy', 'apply'], description: 'Please uncheck the rollAlways if you are using destroy or apply')
    }
    stages {
        stage('Helmfile deployment rollAlways') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "N/A"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
            }}
        }
        stage('Helmfile deployment destroy') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-dev destroy"
            }}
        }
        stage('Helmfile deployment apply') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "apply"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-dev apply"
            }}
        }
    }
}
