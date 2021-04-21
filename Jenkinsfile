def gv

pipeline {
    agent any
    triggers {
        // cron('*/2 * * * 1-5') //each 2min except weekends
        cron('H 10-12/1 * * 1-5') 
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        // if true - always pull the latest docker image
        booleanParam(name: 'rollAlways', defaultValue: false, description: '')
    }
    stages {
        stage("Helmfile deployment rollAlways") {
                when {
                    expression {
                        params.rollAlways == true
                    }
                }
                    steps { script {
                        echo "helmfile -e dbh-v1-dev destroy"
                        echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
                        echo "10:50"
                    }                    
                }
        }
        stage('Helmfile deployment') { 
            when {
                    expression {
                        params.rollAlways == false
                    }
                }
                    steps {  script {
                        echo "10:50"
                        echo "helmfile -e dbh-v1-dev destroy"
                        echo "helmfile -e dbh-v1-dev apply"
        } } }
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
