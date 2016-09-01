import java.util.Random

def call(String host, String credential, Closure body){
    String number = getRandom()
    String workingDir = "$env.WORKSPACE/$number"

    dir (workingDir) {
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$credential", passwordVariable: '$password', usernameVariable: '$username']]) {
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
    Random rand = new Random(10000).toString()
}