def buildApp() {
    echo 'building the application...'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployAppAlways() {
    // sh "helmfile -e dbh-v1-dev destroy"
    echo "helmfile -e dzoni --wait --set deployment.rollAlways=true apply"
    echo "16:42"
    echo "deploying version ${params.VERSION}"
}

def deployApp() {
    // sh "helmfile -e dbh-v1-dev destroy"
    echo "helmfile -e dzoni apply"
    echo "16:42"
    echo "deploying version ${params.VERSION}"
} 

return this
