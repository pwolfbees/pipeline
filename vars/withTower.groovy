import org.apache.commons.lang.RandomStringUtils

def call (host,credentials,Closure body){

    dir ("tmp/${RandomStringUtils.random(9, true, true)}") {

        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$credentials",
                          usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {

            writeFile file: './.tower_cli.cfg',
                    text: "host: $host\nusername: $env.USERNAME \npassword: $env.PASSWORD"

            body()
        }

        deleteDir()
    }
}