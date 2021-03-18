import io.quarkiverse.githubapp.event.Issue;
import io.quarkiverse.githubapp.event.PullRequest;
import org.kohsuke.github.GHEventPayload;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class IssueComment {
   void onOpen(@Issue.Opened GHEventPayload.Issue issuePayload) throws IOException {
      issuePayload.getIssue().comment("Thank you for creating the issue");
   }

   void onAssign(@Issue.Assigned GHEventPayload.Issue issuePayload) throws IOException {
      String assignedUser= issuePayload.getIssue().getAssignee().getName();
      issuePayload.getIssue().comment("Issue successfully assigned to " + assignedUser);
   }

   void onOpenPR(@PullRequest.Opened GHEventPayload.PullRequest pullRequestPayload) throws IOException{
      String contributorName= pullRequestPayload.getPullRequest().getUser().getName();
      pullRequestPayload.getPullRequest().comment("Thanks " + contributorName + " for opening the PR. The team appreciate " +
              "your contribution!");
   }
}
