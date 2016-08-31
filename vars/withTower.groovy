def call(String host, String credential, Closure body){

    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "$credential", passwordVariable: '$password', usernameVariable: '$username']]) {
        writeFile file: './.tower_cli.cfg', text: "host: $host \n username: $username \n password $password"
    }


    body()


}