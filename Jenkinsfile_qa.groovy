def gv

pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
    triggers {
        // cron('H H(1-2) * * 3') //some time between 1:00 AM to 2:59 AM server time
        cron('*/2 * * * *') //some time between 1:00 AM to 2:59 AM server time
    }
    parameters {
        //if true - pull the latest Docker image
        booleanParam(name: 'rollAlways', defaultValue: true, description: 'Pull the latest Docker image')
        choice(name: 'applicationName', choices: ['allApps', 'assets', 'audit', 'auditserver', 'authserver-ma', 'authserver-ma-entersekt', 'authserver-ma-res', 'bff', 'brokerage', 'campaign', 'cardmanagement', 'cloud-boot-admin-server', 'clx-payments', 'contracts', 'digipass', 'estateplanning', 'finhyb', 'identityserver-admin', 'identityserver-oauth', 'identityserver-res', 'instruments', 'investprocess', 'messageintegration', 'onlineintegration', 'rabbitmq', 'scamanagement', 'users', 'finhyb-gui', 'oauth-gui'], description: 'Application name to redeploy/reinstall')
        choice(name: 'DEPLOYMENT', choices: ['apply','destroy'], description: 'Please uncheck the rollAlways when using destroy allApps or destroy per application')
	  }
    agent {
        label 'build_base_pod'
    }

    stages {
        stage('Helmfile deployment rollAlways all applications') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName == "allApps"
                }
            }
            steps { container(name: 'helm') { script {
                echo "helmfile -e dbh-v1-qa --state-values-set wait=true ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}}
        }
        stage('Helmfile deployment rollAlways per application') {
            when {
                expression {
                    params.rollAlways == true && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps { container(name: 'helm') {script {
                echo "helmfile -e dbh-v1-qa --state-values-set wait=true -l app=${applicationName} ${DEPLOYMENT} --set deployment.rollAlways=true"
            }}}
        }
        stage('Helmfile deployment destroy per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName != "allApps"
                }
            }
            steps { container(name: 'helm') { script {
                echo "helmfile -e dbh-v1-qa -l app=${applicationName} ${DEPLOYMENT}"
            }}}
        }
        stage('Helmfile deployment apply per application') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "apply" && params.applicationName != "allApps"
                }
            }
            steps { container(name: 'helm') { script {
                echo "helmfile -e dbh-v1-qa -l app=${applicationName} ${DEPLOYMENT}"
            }}}
        }
        stage('Helmfile deployment destroy all applications') {
            when {
                expression {
                    params.rollAlways == false && params.DEPLOYMENT == "destroy" && params.applicationName == "allApps"
                }
            }
            steps { container(name: 'helm') {script {
                echo "helmfile -e dbh-v1-qa ${DEPLOYMENT}"
            }}}
        }
    }
}
