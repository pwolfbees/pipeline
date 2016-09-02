import java.util.Random

def call (host,credentials,Closure body){
    //host = "foo.com"

    number = "555555"  //getRandom()
    workingDir = "tmp/$number"

    dir (workingDir) {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$credentials",
                          usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
            writeFile file: './.tower_cli.cfg',
                    text: "host: $host\nusername: $env.USERNAME \npassword: $env.PASSWORD"
        }
        body()
    }

    dir(workingDir){
        deleteDir()
    }
}

@NonCPS
def getRandom(){
    Random rand = new Random(99999999)
    return "$rand"
}