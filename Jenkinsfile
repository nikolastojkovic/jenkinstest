def gv

pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: false, name: 'ALL', description: 'Process all'),
        booleanParam(defaultValue: false, name: 'OPTION_1', description: 'Process option 1'),
        booleanParam(defaultValue: false, name: 'OPTION_2', description: 'Process options 2'),
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
            when {
                expression {
                    params.OPTION_1
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
                    params.OPTION_2
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    params.ALL
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
