
def call (Map params, body){
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$params.credentials",
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
        writeFile file: './.tower_cli.cfg',
                text: "host: $params.host\nusername: $env.USERNAME \npassword: $env.PASSWORD\nverify_ssl: false"
        body()
        }
        sh "rm ./.tower_cli.cfg"
}
