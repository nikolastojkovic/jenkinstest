def gv

pipeline {
    agent any
    triggers {
        cron('*/2 * * * 1-5') //eash 
        // cron('50 16 * * 1-5') 
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
        stage("Helmfile rollAlways") {
            when {
                expression {
                    params.rollAlways == true
                }
            }
            steps {
                script {
                    gv.deployAppAlways()
                }
            }
        }
        stage("Helmfile deployment") {
            when {
                expression {
                    params.rollAlways == false
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
