import hudson.model.Result;

def call() {
    executor = currentBuild.rawBuild.getParent().getBuildByNumber(currentBuild.number-1).getExecutor()

    if (executor != null) {
        executor.interrupt(Result.NOT_BUILT)
        executor = null
    } else {
        echo "could not cancel an older flow because it has no assigned executor"
    }
}
