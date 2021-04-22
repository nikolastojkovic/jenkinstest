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
<<<<<<< Updated upstream
        // choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        // if true - always pull the latest docker image
        booleanParam(name: 'rollAlways', defaultValue: true, description: 'Pull the latest Docker image')
        booleanParam(name: 'destroyApply', defaultValue: false, description: 'Helmfile -e dbh-v1-dev destroy & apply')
=======
        activeChoiceParam('CHOICE-1') {
            description('Allows user choose from multiple choices')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["choice1", "choice2"]')
                fallbackScript('"fallback choice"')
            }
        }
>>>>>>> Stashed changes
    }
    stages {
        stage('Helmfile deployment rollAlways') {
            when {
                expression {
                    params.rollAlways == true && params.destroyApply == false
<<<<<<< Updated upstream
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
            }}
        }
        stage('Helmfile deployment') {
            when {
                expression {
                    params.rollAlways == false && params.destroyApply == true
                }
            }
=======
                }
            }
            steps {  script {
                echo "ovaj ide"
                echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
            }}
        }
        stage('Helmfile deployment') {
            when {
                expression {
                    params.rollAlways == false && params.destroyApply == true
                }
            }
>>>>>>> Stashed changes
            steps { script {
                echo "helmfile -e dbh-v1-dev destroy"
                echo "helmfile -e dbh-v1-dev apply"
            }}
        }
    }
<<<<<<< Updated upstream
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
=======
    
>>>>>>> Stashed changes
}
