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
        activeChoiceParam('CHOICE-1') {
            description('Allows user choose from multiple choices')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["choice1", "choice2"]')
                fallbackScript('"fallback choice"')
            }
        }
    }
    stages {
        stage('Helmfile deployment rollAlways') {
            when {
                expression {
                    params.rollAlways == true && params.destroyApply == false
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
            steps { script {
                echo "helmfile -e dbh-v1-dev destroy"
                echo "helmfile -e dbh-v1-dev apply"
            }}
        }
    }
    
}
