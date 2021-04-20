def gv

pipeline {
    agent any
    triggers {
        cron('42 16 * * 1-5') 
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'rollAlways', defaultValue: false, description: '')
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
            if {
                expression {
                    params.rollAlways == true
                }
                steps {
                script {
                    gv.deployApp()
                }
            }
            }
            else {
                steps {
                script {
                    gv.deployApp()
                }
            }
            
        }
    }   
}
