import java.util.Random

def call (Closure body){
    host = "foo.com"

    number = "555555"  //getRandom()
    workingDir = "$env.WORKSPACE/$number"

    dir (workingDir) {
        withCredentials([[$class: 'UsernamePasswordMultiBinding',
                          credentialsId: "tower-cli", passwordVariable:
                                  '$password', usernameVariable: '$username']]) {
            writeFile file: './.tower_cli.cfg', text: "host: $host \n username: $username \n password $password"
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