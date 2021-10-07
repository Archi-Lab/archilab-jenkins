import hudson.model.*;

multiBranchProjects = Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject)

for (mbProject in multiBranchProjects) {
    mbProject.computation.run()
}
