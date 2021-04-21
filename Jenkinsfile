def gv

pipeline {
    agent any
    triggers {
        // cron('*/2 * * * 1-5') //each 2min each workday
        // cron('H 10-12/1 * * 1-5')
        pollSCM('*/2 * * * 1-5') // poll every 2min each workday
        // pollSCM('06 10 * * 1-5') // UTC time
    }
    parameters {
        // choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        // if true - always pull the latest docker image
        booleanParam(name: 'rollAlways', defaultValue: false, description: 'Pull the latest Docker image')
    }
    stages {
        stage('Helmfile deployment rollAlways') {
            when {
                expression {
                    params.rollAlways == true
                }
            }
            steps { container(name: 'helm') { script {
                echo "helmfile -e dbh-v1-dev destroy"
                echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
            }}}
        }
        stage('Helmfile deployment') {
            when {
                expression {
                    params.rollAlways == false
                }
            }
            steps { container(name: 'helm') { script {
                echo "helmfile -e dbh-v1-dev destroy"
                echo "helmfile -e dbh-v1-dev apply"
            }}}
        }
    }
    // stages {
    //     stage("init") {
    //         steps {
    //             script {
    //                gv = load "script.groovy" 
    //             }
    //         }
    //     }
    //     stage("build") {
    //         steps {
    //             script {
    //                 gv.buildApp()
    //             }
    //         }
    //     }
    //     stage("Helmfile rollAlways") {
    //         when {
    //             expression {
    //                 params.rollAlways == true
    //             }
    //         }
    //         steps {
    //             script {
    //                 gv.deployAppAlways()
    //             }
    //         }
    //     }
    //     stage("Helmfile deployment") {
    //         when {
    //             expression {
    //                 params.rollAlways == false
    //             }
    //         }
    //         steps {
    //             script {
    //                 gv.deployApp()
    //             }
    //         }
    //     }
        
    // }   
}
