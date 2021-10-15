import jenkins.branch.*
import jenkins.model.Jenkins


for (f in Jenkins.instance.getAllItems(jenkins.branch.MultiBranchProject.class)) {
  if (f.parent instanceof jenkins.branch.OrganizationFolder) {
    continue;
  }
  f.computation.run()
}