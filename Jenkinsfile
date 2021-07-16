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
        choice(name: 'applicationName', choices: ['allApps', 'assets', 'audit', 'auditserver', 'authserver-ma', 'authserver-ma-entersekt', 'authserver-ma-res', 'bff', 'brokerage', 'campaign', 'cardmanagement', 'cloud-boot-admin-server', 'clx-payments', 'contracts', 'dbh-nhub', 'digipass', 'estateplanning', 'finhyb', 'identityserver-admin', 'identityserver-oauth', 'identityserver-res', 'instruments', 'investprocess', 'messageintegration-hp', 'messageintegration', 'mockserver', 'nhub-timeline', 'onlineintegration', 'rabbitmq', 'scamanagement', 'users', 'finhyb-gui', 'oauth-gui'], description: 'Application name to redeploy/reinstall')
        choice(name: 'DEPLOYMENT', choices: ['apply','destroy' ], description: 'Please uncheck the rollAlways if you are using destroy or apply')
    }
    stages {
        stage('Helmfile deployment rollAlways all applications') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName == "allApps"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-dev --state-values-set wait=true ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}
        }
        stage('Helmfile deployment rollAlways per application') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-dev --state-values-set wait=true -l app=${applicationName} ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}
        }
        stage('Helmfile deployment destroy per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName != "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-dev -l app=${applicationName} ${DEPLOYMENT}"
            }}
        }
        stage('Helmfile deployment apply per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-dev -l app=${applicationName} ${DEPLOYMENT}"
            }}
        }
        stage('Helmfile deployment destroy all applications') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName == "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-dev ${DEPLOYMENT}"
            }}
        }
    }
<<<<<<< HEAD
    
=======
>>>>>>> aa56590697f1e488f7fa0369c66b821174c6643c
}
