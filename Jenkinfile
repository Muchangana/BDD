node('master'){
stage('SCM Checkout'){
    git 'https://github.com/muchangana/BDD'
}
stage('Build'){
def mvnHome = tool name: 'M2_HOME', type: 'maven'
sh "${mvnHome}"/bin/mvn clean test"
}

}