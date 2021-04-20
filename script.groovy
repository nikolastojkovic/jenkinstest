def buildApp() {
    echo 'building the application...'
} 

def deployAppAlways() {
    // sh "helmfile -e dbh-v1-dev destroy"
    echo "helmfile -e dbh-v1-dev --wait --set deployment.rollAlways=true apply"
    echo "17:40"
    echo "deploying version ${params.VERSION}"
}

def deployApp() {
    // sh "helmfile -e dbh-v1-dev destroy"
    echo "helmfile -e dbh-v1-dev apply"
    echo "17:17"
    echo "deploying version ${params.VERSION}"
} 

return this
