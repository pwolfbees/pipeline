#!/usr/bin/env groovy

def call(String file, String context, String destination) {

    echo "#!/busybox/sh  /kaniko/executor -f $file -c $context -d $destination"

}