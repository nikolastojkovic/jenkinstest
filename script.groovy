def buildApp() {
    echo 'building the application...'
} 

def testApp() {
    echo 'testing the application...'
} 

def deployApp() {
    // sh "helmfile -e dbh-v1-dev destroy"
    echo "helmfile -e dzoni --wait --set deployment.rollAlways=true apply"
    echo "16:05"
    echo "deploying version ${params.VERSION}"
} 

return this
