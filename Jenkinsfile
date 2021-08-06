// def gv

pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: true, name: 'ALL', description: 'Process all')
        booleanParam(defaultValue: false, name: 'assets', description: 'Process assets')
        booleanParam(defaultValue: false, name: 'audit', description: 'Process audit')
        booleanParam(defaultValue: false, name: 'contracts', description: 'Process contracts')        
        booleanParam(defaultValue: false, name: 'identityserver-oauth', description: 'Process identityserver-oauth')
        booleanParam(defaultValue: false, name: 'nhub', description: 'Process ')
        booleanParam(defaultValue: false, name: 'payments', description: 'Process payments')
        booleanParam(defaultValue: false, name: 'timeline', description: 'Process timeline')
        booleanParam(defaultValue: false, name: 'users', description: 'Process users')
    }
    stages {
        stage("all") {
            when {
                expression {
                    params.all == true
                }
            }
            steps {
                script {
                   echo "deploying all ${params.all}" 
                }
            }
        }
        stage("assets") {
            when {
                expression {
                    params.assets == true
                }
            }
            steps {
                script {
                    echo "deploying assets ${params.assets}"
                }
            }
        }
        stage("audit") {
            when {
                expression {
                    params.audit == true
                }
            }
            steps {
                script {
                    echo "deploying audit ${params.audit}"
                }
            }
        }
        stage("contracts") {
            when {
                expression {
                    params.contracts == true
                }
            }
            steps {
                script {
                    echo "deploying contracts ${params.contracts}"
                }
            }
        }
        stage("identityserver-oauth") {
            when {
                expression {
                    params.identityserver-oauth == true
                }
            }
            steps {
                script {
                   echo "deploying identityserver-oauth ${params.identityserver-oauth}" 
                }
            }
        }
        stage("nhub") {
            when {
                expression {
                    params.nhub == true
                }
            }
            steps {
                script {
                    echo "deploying nhub ${params.nhub}"
                }
            }
        }
        stage("payments") {
            when {
                expression {
                    params.payments == true
                }
            }
            steps {
                script {
                    echo "deploying payments ${params.payments}"
                }
            }
        }
        stage("timeline") {
            when {
                expression {
                    params.timeline == true
                }
            }
            steps {
                script {
                    echo "deploying timeline ${params.timeline}"
                }
            }
        }
        stage("users") {
            when {
                expression {
                    params.users == true
                }
            }
            steps {
                script {
                    echo "deploying users ${params.users}"
                }
            }
        }
    }   
}
