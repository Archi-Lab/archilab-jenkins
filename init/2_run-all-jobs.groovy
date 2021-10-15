import hudson.model.*;

jobs = Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)

for (job in jobs) {
    if (job instanceof BuildableItem) {
      job.scheduleBuild();
    }
}
