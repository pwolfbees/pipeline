import org.apache.commons.lang.RandomStringUtils

def call (host,credentials,Closure body){

    //number = getRandom()
    workingDir = random(9, true, true)

    dir (workingDir) {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$credentials",
                          usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
            writeFile file: './.tower_cli.cfg',
                    text: "host: $host\nusername: $env.USERNAME \npassword: $env.PASSWORD"
            body()
        }

        deleteDir()
    }

}

@NonCPS
def getRandom(){
    Random rand = new Random(99999999)
    return "$rand"
}