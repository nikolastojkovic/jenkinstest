def gv

pipeline {
    agent any
    triggers {
        // cron('H 10-12/1 * * 1-5')
        cron('40 14 * * 5') // poll every 2min each workday
        // pollSCM('06 10 * * 1-5') // UTC time
    }
    parameters {
        booleanParam(name: 'rollAlways', defaultValue: true, description: 'Pull the latest Docker image')
        choice(name: 'applicationName', choices: ['allApps', 'assets', 'audit', 'authserver-ma', 'authserver-ma-entersekt', 'authserver-ma-res', 'bff', 'brokerage', 'campaign', 'cardmanagement', 'cloud-boot-admin-server', 'payments', 'contracts', 'digipass', 'estateplanning', 'finhyb', 'identityserver-admin', 'identityserver-oauth', 'identityserver-res', 'instruments', 'investprocess', 'messageintegration', 'onlineintegration', 'rabbitmq', 'users', 'finhyb-gui', 'oauth-gui'], description: 'Application name to redeploy/reinstall')
        string(name: 'TIMEOUT', defaultValue: '600', description: 'Helm will wait (timeout in seconds) until a minimum expected number of Pods in the deployment are launched before marking the release as successful.', trim: true)
        choice(name: 'DEPLOYMENT', choices: ['apply','sync','destroy'], description: 'Please uncheck the rollAlways when using destroy allApps or destroy per application')
    }
    stages {
        stage('Deployment rollAlways all applications') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName == "allApps"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-qa --state-values-set wait=true --state-values-set timeout=${TIMEOUT} ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}
        }
        stage('Deployment rollAlways per application') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-qa --state-values-set wait=true --timeout ${TIMEOUT} -l app=${applicationName} ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}
        }
        stage('Deployment rollAlways sync per application') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "sync" && params.applicationName != "allApps"
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-qa --state-values-set wait=true --timeout ${TIMEOUT} -l app=${applicationName} ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}
        }
        stage('Deployment destroy per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName != "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-qa -l app=${applicationName} ${DEPLOYMENT}"
            }}
        }
        stage('Deployment apply per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-qa -l app=${applicationName} ${DEPLOYMENT}"
            }}
        }
        stage('Deployment sync per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "sync" && params.applicationName != "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-qa -l app=${applicationName} ${DEPLOYMENT}"
            }}
        }
        stage('Deployment destroy all applications') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName == "allApps"
                }
            }
            steps { script {
                echo "helmfile -e dbh-v1-qa ${DEPLOYMENT}"
            }}
        }
    }
}