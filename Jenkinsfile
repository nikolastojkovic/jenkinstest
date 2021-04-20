def gv

pipeline {
    agent any
    triggers {
        cron('26 16 * * 1-5') 
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'rollAlways', defaultValue: true, description: '')
    }
    stages {
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy" 
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("Helmfile deployment") {
            when {
                expression {
                    params.rollAlways
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}
