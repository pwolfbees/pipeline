def call (Map params){
    myENV = params.envVarName
    evaluate("env.${params.envVarName}" = params.step params.arg")
}
