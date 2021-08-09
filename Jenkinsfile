def gv

pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: true, name: 'ALL', description: 'Testdata for all')
        booleanParam(defaultValue: false, name: 'AUDIT', description: 'Testdata for audit')
        booleanParam(defaultValue: false, name: 'APHM', description: 'Testdata for assets')        
        booleanParam(defaultValue: false, name: 'CONT', description: 'Testdata for contracts')        
        booleanParam(defaultValue: false, name: 'OAUTH', description: 'Testdata for identityserver-oauth')
        booleanParam(defaultValue: false, name: 'NOHM', description: 'Testdata for nhub ')
        booleanParam(defaultValue: false, name: 'PHM', description: 'Testdata for payments')
        booleanParam(defaultValue: false, name: 'NOTI', description: 'Testdata for timeline')
        booleanParam(defaultValue: false, name: 'UHM', description: 'Testdata for users')
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
                   echo "deploying all ${all}" 
                }
            }
        }
        stage("audit") {
            when {
                expression {
                    params.AUDIT == true
                }
            }
            steps {
                script {
                    echo "deploying audit ${AUDIT}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-audit' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=AUDIT'"
                }
            }
        }
        stage("assets") {
            when {
                expression {
                    params.APHM == true
                }
            }
            steps {
                script {
                    echo "deploying assets ${APHM}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-assets' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=APHM'"
                }
            }
        }
        stage("contracts") {
            when {
                expression {
                    params.CONT == true
                }
            }
            steps {
                script {
                    echo "deploying contracts ${CONT}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-contracts' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=CONT'"
                }
            }
        }
        stage("identityserver-oauth") {
            when {
                expression {
                    params.OAUTH == true
                }
            }
            steps {
                script {
                   echo "deploying identityserver-oauth ${OAUTH}"
                   echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-aso' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=OAUTH'"
                }
            }
        }
        stage("nhub") {
            when {
                expression {
                    params.NOHM == true
                }
            }
            steps {
                script {
                    echo "deploying nhub ${NOHM}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-nhub' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=NOHM'"
                }
            }
        }
        stage("payments") {
            when {
                expression {
                    params.PHM == true
                }
            }
            steps {
                script {
                    echo "deploying payments ${PHM}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-payments' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=PHM'"
                }
            }
        }
        stage("timeline") {
            when {
                expression {
                    params.NOTI == true
                }
            }
            steps {
                script {
                    echo "deploying timeline ${NOTI}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-timeline' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=NOTI'"
                }
            }
        }
        stage("users") {
            when {
                expression {
                    params.UHM == true
                }
            }
            steps {
                script {
                    echo "deploying users ${UHM}"
                    echo "kubectl run testdataimporter --image=docker-develop.artifactory.devops.crealogix.com/testdataimporter:latest --env='DRIVER=org.mariadb.jdbc.Driver' --env='URL=jdbc:mariadb://c20-k8s-db-01.crealogix.net:3306/dbh-v1-qa-users' --env='USERNAME=dbh-v1-qa' --env='PASSWORD=crealogix' --env='HM=UHM'"
                }
            }
        }
    }
}
