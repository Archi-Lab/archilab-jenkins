import hudson.model.*;

jobs = Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)

for (job in jobs) {
  if(job.isBuildable()) {
    if (!job.isBuilding() && !job.isInQueue()) {
      job.scheduleBuild();
    }
  }
}
